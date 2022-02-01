package com.tencent.mobileqq.activity.emogroupstore;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.mobileqq.emosm.api.IEmoticonFromGroupDBManagerService;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emosm.favroaming.IEmoticonFromGroupManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class PicSelectAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  public boolean a;
  private QQAppInterface b;
  private Context c;
  private EmoticonGroupStoreFragment d;
  private Map<String, List<EmoticonFromGroupEntity>> e;
  private Map<String, String> f = new HashMap();
  private int g;
  private LayoutInflater h;
  private Map<Integer, Integer> i = new HashMap();
  private Map<Integer, String> j = new HashMap();
  private Map<Integer, List<EmoticonFromGroupEntity>> k = new TreeMap();
  private boolean l;
  private int m = -1;
  private View n;
  private Button o;
  private ImageView p;
  private TextView q;
  private ViewPager r;
  private ImgPreviewAdapter s;
  private Button t;
  private IEmoticonFromGroupDBManagerService u;
  private IEmoticonFromGroupManager v;
  private PicSelectAdapter.OnImgClickListener w = new PicSelectAdapter.3(this);
  
  public PicSelectAdapter(QQAppInterface paramQQAppInterface, EmoticonGroupStoreFragment paramEmoticonGroupStoreFragment, int paramInt, View paramView, ViewPager paramViewPager, Button paramButton)
  {
    this.b = paramQQAppInterface;
    this.d = paramEmoticonGroupStoreFragment;
    this.c = this.d.getBaseActivity();
    this.g = paramInt;
    this.n = paramView;
    this.o = ((Button)this.n.findViewById(2131429905));
    this.p = ((ImageView)this.n.findViewById(2131435550));
    this.q = ((TextView)this.n.findViewById(2131448928));
    this.r = paramViewPager;
    this.r.setPageMargin(2);
    this.h = LayoutInflater.from(this.c);
    this.s = new ImgPreviewAdapter(this.b, this.c, this.r);
    this.r.setAdapter(this.s);
    this.r.setOnPageChangeListener(new PicSelectAdapter.1(this));
    this.t = paramButton;
    this.u = ((IEmoticonFromGroupDBManagerService)paramQQAppInterface.getRuntimeService(IEmoticonFromGroupDBManagerService.class));
    this.v = ((VasExtensionManager)paramQQAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).d;
    this.v.f();
  }
  
  private void a()
  {
    Iterator localIterator = this.e.entrySet().iterator();
    int i1 = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      this.j.put(Integer.valueOf(i1), str);
      this.i.put(Integer.valueOf(i1), Integer.valueOf(0));
      localObject = (List)((Map.Entry)localObject).getValue();
      int i6 = ((List)localObject).size();
      double d1 = i6;
      Double.isNaN(d1);
      int i7 = (int)Math.ceil(d1 / 3.0D);
      i1 += 1;
      int i2 = 0;
      int i5;
      for (int i3 = 0; i2 < i7; i3 = i5)
      {
        ArrayList localArrayList = new ArrayList();
        int i4 = 0;
        for (;;)
        {
          i5 = i3 + i4;
          if ((i5 >= i6) || (i4 >= 3)) {
            break;
          }
          localArrayList.add(((List)localObject).get(i5));
          i4 += 1;
        }
        this.j.put(Integer.valueOf(i1), str);
        this.k.put(Integer.valueOf(i1), localArrayList);
        this.i.put(Integer.valueOf(i1), Integer.valueOf(1));
        i2 += 1;
        i1 += 1;
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default: 
      paramInt2 = -1;
      break;
    case 2131435575: 
      paramInt2 = 2;
      break;
    case 2131435574: 
      paramInt2 = 1;
      break;
    case 2131435573: 
      paramInt2 = 0;
    }
    Object localObject = (EmoticonFromGroupEntity)((List)this.k.get(Integer.valueOf(paramInt1))).get(paramInt2);
    if (this.l)
    {
      if (-1 != ((EmoticonFromGroupEntity)localObject).status)
      {
        paramInt1 = ((EmoticonFromGroupEntity)localObject).status;
        if (((EmoticonFromGroupEntity)localObject).status != 0)
        {
          this.d.a.remove(localObject);
          ((EmoticonFromGroupEntity)localObject).status = -1;
          localObject = this.d.a.iterator();
          while (((Iterator)localObject).hasNext())
          {
            EmoticonFromGroupEntity localEmoticonFromGroupEntity = (EmoticonFromGroupEntity)((Iterator)localObject).next();
            if (localEmoticonFromGroupEntity.status > paramInt1) {
              localEmoticonFromGroupEntity.status -= 1;
            }
          }
          notifyDataSetChanged();
        }
      }
      else
      {
        paramInt1 = this.d.a.size();
        if (this.u.getCountOfSpare() <= paramInt1)
        {
          if (300 == FavEmoConstant.a)
          {
            QQToast.makeText(this.c, 2131886259, 0).show(2131299920);
          }
          else if (144 == FavEmoConstant.a)
          {
            localObject = new PicSelectAdapter.2(this);
            localObject = DialogUtil.a(this.c, 0, HardCodeUtil.a(2131905958), this.c.getString(2131886258), HardCodeUtil.a(2131898212), HardCodeUtil.a(2131905960), (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
            if (localObject != null) {
              ((QQCustomDialog)localObject).show();
            }
          }
        }
        else if (20 > this.d.a.size())
        {
          this.d.a.add(localObject);
          ((EmoticonFromGroupEntity)localObject).status = this.d.a.size();
          notifyDataSetChanged();
        }
        else
        {
          QQToast.makeText(this.c, "单次最多收藏20个表情哦~", 0).show(2131299920);
        }
      }
      if (this.d.a.size() > 0)
      {
        this.t.setTextColor(Color.parseColor("#FFFFFFFF"));
        this.t.setBackgroundDrawable(this.c.getResources().getDrawable(2130845842));
        this.t.setEnabled(true);
        return;
      }
      this.t.setTextColor(Color.parseColor("#FFBFBFBF"));
      this.t.setBackgroundDrawable(this.c.getResources().getDrawable(2130845843));
      this.t.setEnabled(false);
      return;
    }
    a((EmoticonFromGroupEntity)localObject, paramInt2, paramInt1);
  }
  
  private void a(EmoticonFromGroupEntity paramEmoticonFromGroupEntity)
  {
    int i1 = paramEmoticonFromGroupEntity.fromType;
    String str = null;
    Object localObject;
    if (1 == i1)
    {
      localObject = this.b.getFaceBitmap(4, paramEmoticonFromGroupEntity.troopUin, (byte)2, false, (byte)1, 0);
      str = ContactUtils.a(this.b, paramEmoticonFromGroupEntity.troopUin, true);
      paramEmoticonFromGroupEntity = (EmoticonFromGroupEntity)localObject;
      localObject = str;
    }
    else if (3000 == paramEmoticonFromGroupEntity.fromType)
    {
      localObject = this.b.getFaceBitmap(101, paramEmoticonFromGroupEntity.troopUin, (byte)3, false, (byte)1, 0);
      str = ContactUtils.a(this.b, this.c, paramEmoticonFromGroupEntity.troopUin);
      paramEmoticonFromGroupEntity = (EmoticonFromGroupEntity)localObject;
      localObject = str;
    }
    else
    {
      localObject = null;
      paramEmoticonFromGroupEntity = str;
    }
    this.p.setImageBitmap(paramEmoticonFromGroupEntity);
    this.q.setText((CharSequence)localObject);
  }
  
  private void a(EmoticonFromGroupEntity paramEmoticonFromGroupEntity, int paramInt1, int paramInt2)
  {
    AbstractGifImage.resumeAll();
    a(paramEmoticonFromGroupEntity);
    if (-1 != paramEmoticonFromGroupEntity.status)
    {
      if (paramEmoticonFromGroupEntity.status == 0)
      {
        this.o.setText(HardCodeUtil.a(2131905956));
        this.o.setTextColor(Color.parseColor("#FFBBBBBB"));
        this.o.setBackgroundDrawable(this.c.getResources().getDrawable(2130845843));
        this.o.setEnabled(false);
      }
    }
    else
    {
      this.o.setText(HardCodeUtil.a(2131905957));
      this.o.setTextColor(Color.parseColor("#FFFFFFFF"));
      this.o.setBackgroundDrawable(this.c.getResources().getDrawable(2130845842));
      this.o.setEnabled(true);
    }
    if (this.k.containsKey(Integer.valueOf(paramInt2)))
    {
      if (this.d.titleRoot != this.n.getParent())
      {
        this.d.titleRoot.addView(this.n);
        this.d.a(false);
      }
      int i1 = 0;
      int i3;
      for (int i2 = 0; i1 < paramInt2; i2 = i3)
      {
        i3 = i2;
        if (this.k.containsKey(Integer.valueOf(i1))) {
          i3 = i2 + ((List)this.k.get(Integer.valueOf(i1))).size();
        }
        i1 += 1;
      }
      this.r.setCurrentItem(i2 + paramInt1, false);
    }
    VasWebviewUtil.a("", "QLbq", "ClickPreview", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
  }
  
  private void b(EmoticonFromGroupEntity paramEmoticonFromGroupEntity)
  {
    if (paramEmoticonFromGroupEntity.status == 0)
    {
      this.o.setText(HardCodeUtil.a(2131905961));
      this.o.setTextColor(Color.parseColor("#FFBBBBBB"));
      this.o.setBackgroundDrawable(this.c.getResources().getDrawable(2130845843));
      this.o.setEnabled(false);
      return;
    }
    this.o.setText(HardCodeUtil.a(2131905959));
    this.o.setTextColor(Color.parseColor("#FFFFFFFF"));
    this.o.setBackgroundDrawable(this.c.getResources().getDrawable(2130845842));
    this.o.setEnabled(true);
  }
  
  public String a(int paramInt)
  {
    String str = (String)this.j.get(Integer.valueOf(paramInt));
    return (String)this.f.get(str);
  }
  
  public void a(Map<String, List<EmoticonFromGroupEntity>> paramMap, List<EmoticonFromGroupEntity> paramList)
  {
    this.e = paramMap;
    this.k.clear();
    this.j.clear();
    this.i.clear();
    a();
    this.f.clear();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (List)((Map.Entry)localObject).getValue();
      this.f.put(str, this.v.a(str, ((List)localObject).size(), "  "));
    }
    notifyDataSetChanged();
    this.s.a(paramList);
    this.s.notifyDataSetChanged();
  }
  
  public boolean a(boolean paramBoolean)
  {
    boolean bool = this.l;
    this.l = paramBoolean;
    return bool;
  }
  
  public int getItemCount()
  {
    Object localObject = this.e;
    int i1 = 0;
    int i2 = 0;
    if (localObject != null)
    {
      int i3 = ((Map)localObject).size();
      localObject = this.e.entrySet().iterator();
      i1 = i2;
      while (((Iterator)localObject).hasNext())
      {
        double d1 = ((List)((Map.Entry)((Iterator)localObject).next()).getValue()).size();
        Double.isNaN(d1);
        i1 += (int)Math.ceil(d1 / 3.0D);
      }
      i1 = i3 + i1 + 1;
    }
    return i1;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == getItemCount() - 1) {
      return 2;
    }
    return ((Integer)this.i.get(Integer.valueOf(paramInt))).intValue();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof PicSelectAdapter.PicItemViewHolder))
    {
      PicSelectAdapter.PicItemViewHolder localPicItemViewHolder = (PicSelectAdapter.PicItemViewHolder)paramViewHolder;
      List localList = (List)this.k.get(Integer.valueOf(paramInt));
      int i2 = localList.size();
      int i1 = 0;
      while (i1 < 3)
      {
        RelativeLayout localRelativeLayout = (RelativeLayout)localPicItemViewHolder.j[i1].getParent();
        if (i1 < i2)
        {
          localRelativeLayout.setVisibility(0);
          localPicItemViewHolder.j[i1].setImageDrawable(this.v.a((EmoticonFromGroupEntity)localList.get(i1), 65537, this.g, null));
          this.m = ((EmoticonFromGroupEntity)((List)this.k.get(Integer.valueOf(paramInt))).get(i1)).status;
          if (this.m == 0)
          {
            localPicItemViewHolder.k[i1].setVisibility(4);
            localPicItemViewHolder.l[i1].setVisibility(0);
            paramViewHolder.itemView.setClickable(false);
          }
          else if (this.a)
          {
            localPicItemViewHolder.l[i1].setVisibility(4);
            if (this.m > 0)
            {
              localPicItemViewHolder.k[i1].setVisibility(0);
              localPicItemViewHolder.k[i1].setCheckedNumber(this.m);
            }
            else
            {
              localPicItemViewHolder.k[i1].setChecked(false);
              localPicItemViewHolder.k[i1].setVisibility(0);
            }
          }
          else
          {
            localPicItemViewHolder.k[i1].setVisibility(4);
            localPicItemViewHolder.l[i1].setVisibility(4);
          }
        }
        else
        {
          localRelativeLayout.setVisibility(4);
        }
        i1 += 1;
      }
      paramViewHolder.itemView.setTag(Integer.valueOf(paramInt));
    }
    else if ((paramViewHolder instanceof PicSelectAdapter.DateItemViewHolder))
    {
      ((PicSelectAdapter.DateItemViewHolder)paramViewHolder).a.setText((CharSequence)this.f.get(this.j.get(Integer.valueOf(paramInt))));
    }
    else if ((paramViewHolder instanceof PicSelectAdapter.HintTxtViewholder))
    {
      ((PicSelectAdapter.HintTxtViewholder)paramViewHolder).a.setText("仅保留最新的300个聊天表情，\n更多表情请在消息记录中查找哦～");
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("view type: ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("GroupEmoUI.PicSelectAdapter", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return null;
        }
        return new PicSelectAdapter.HintTxtViewholder(this.h.inflate(2131628321, paramViewGroup, false));
      }
      paramViewGroup = this.h.inflate(2131628318, paramViewGroup, false);
      localObject = (RecyclerView.LayoutParams)paramViewGroup.getLayoutParams();
      ((RecyclerView.LayoutParams)localObject).height = this.g;
      paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramViewGroup = new PicSelectAdapter.PicItemViewHolder(paramViewGroup);
      paramViewGroup.a(this.w);
      return paramViewGroup;
    }
    return new PicSelectAdapter.DateItemViewHolder(this.h.inflate(2131628317, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.PicSelectAdapter
 * JD-Core Version:    0.7.0.1
 */