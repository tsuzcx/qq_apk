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
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ViewPager jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
  private EmoticonGroupStoreFragment jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreEmoticonGroupStoreFragment;
  private ImgPreviewAdapter jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreImgPreviewAdapter;
  private PicSelectAdapter.OnImgClickListener jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter$OnImgClickListener = new PicSelectAdapter.3(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IEmoticonFromGroupDBManagerService jdField_a_of_type_ComTencentMobileqqEmosmApiIEmoticonFromGroupDBManagerService;
  private IEmoticonFromGroupManager jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIEmoticonFromGroupManager;
  private Map<String, List<EmoticonFromGroupEntity>> jdField_a_of_type_JavaUtilMap;
  public boolean a;
  private int jdField_b_of_type_Int = -1;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private Map<String, String> jdField_b_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean;
  private Map<Integer, Integer> c = new HashMap();
  private Map<Integer, String> d = new HashMap();
  private Map<Integer, List<EmoticonFromGroupEntity>> e = new TreeMap();
  
  public PicSelectAdapter(QQAppInterface paramQQAppInterface, EmoticonGroupStoreFragment paramEmoticonGroupStoreFragment, int paramInt, View paramView, ViewPager paramViewPager, Button paramButton)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreEmoticonGroupStoreFragment = paramEmoticonGroupStoreFragment;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreEmoticonGroupStoreFragment.getBaseActivity();
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363949));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368638));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380023));
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager = paramViewPager;
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setPageMargin(2);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreImgPreviewAdapter = new ImgPreviewAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager);
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreImgPreviewAdapter);
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setOnPageChangeListener(new PicSelectAdapter.1(this));
    this.jdField_b_of_type_AndroidWidgetButton = paramButton;
    this.jdField_a_of_type_ComTencentMobileqqEmosmApiIEmoticonFromGroupDBManagerService = ((IEmoticonFromGroupDBManagerService)paramQQAppInterface.getRuntimeService(IEmoticonFromGroupDBManagerService.class));
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIEmoticonFromGroupManager = ((VasExtensionManager)paramQQAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIEmoticonFromGroupManager;
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIEmoticonFromGroupManager.a();
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      this.d.put(Integer.valueOf(i), str);
      this.c.put(Integer.valueOf(i), Integer.valueOf(0));
      localObject = (List)((Map.Entry)localObject).getValue();
      int i1 = ((List)localObject).size();
      double d1 = i1;
      Double.isNaN(d1);
      int i2 = (int)Math.ceil(d1 / 3.0D);
      i += 1;
      int j = 0;
      int n;
      for (int k = 0; j < i2; k = n)
      {
        ArrayList localArrayList = new ArrayList();
        int m = 0;
        for (;;)
        {
          n = k + m;
          if ((n >= i1) || (m >= 3)) {
            break;
          }
          localArrayList.add(((List)localObject).get(n));
          m += 1;
        }
        this.d.put(Integer.valueOf(i), str);
        this.e.put(Integer.valueOf(i), localArrayList);
        this.c.put(Integer.valueOf(i), Integer.valueOf(1));
        j += 1;
        i += 1;
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
    case 2131368662: 
      paramInt2 = 2;
      break;
    case 2131368661: 
      paramInt2 = 1;
      break;
    case 2131368660: 
      paramInt2 = 0;
    }
    Object localObject = (EmoticonFromGroupEntity)((List)this.e.get(Integer.valueOf(paramInt1))).get(paramInt2);
    if (this.jdField_b_of_type_Boolean)
    {
      if (-1 != ((EmoticonFromGroupEntity)localObject).status)
      {
        paramInt1 = ((EmoticonFromGroupEntity)localObject).status;
        if (((EmoticonFromGroupEntity)localObject).status != 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreEmoticonGroupStoreFragment.a.remove(localObject);
          ((EmoticonFromGroupEntity)localObject).status = -1;
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreEmoticonGroupStoreFragment.a.iterator();
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
        paramInt1 = this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreEmoticonGroupStoreFragment.a.size();
        if (this.jdField_a_of_type_ComTencentMobileqqEmosmApiIEmoticonFromGroupDBManagerService.getCountOfSpare() <= paramInt1)
        {
          if (300 == FavEmoConstant.jdField_a_of_type_Int)
          {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131689648, 0).b(2131299168);
          }
          else if (144 == FavEmoConstant.jdField_a_of_type_Int)
          {
            localObject = new PicSelectAdapter.2(this);
            localObject = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 0, HardCodeUtil.a(2131708162), this.jdField_a_of_type_AndroidContentContext.getString(2131689647), HardCodeUtil.a(2131708163), HardCodeUtil.a(2131708165), (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
            if (localObject != null) {
              ((QQCustomDialog)localObject).show();
            }
          }
        }
        else if (20 > this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreEmoticonGroupStoreFragment.a.size())
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreEmoticonGroupStoreFragment.a.add(localObject);
          ((EmoticonFromGroupEntity)localObject).status = this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreEmoticonGroupStoreFragment.a.size();
          notifyDataSetChanged();
        }
        else
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, "单次最多收藏20个表情哦~", 0).b(2131299168);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreEmoticonGroupStoreFragment.a.size() > 0)
      {
        this.jdField_b_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#FFFFFFFF"));
        this.jdField_b_of_type_AndroidWidgetButton.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844469));
        this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
        return;
      }
      this.jdField_b_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#FFBFBFBF"));
      this.jdField_b_of_type_AndroidWidgetButton.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844470));
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
      return;
    }
    a((EmoticonFromGroupEntity)localObject, paramInt2, paramInt1);
  }
  
  private void a(EmoticonFromGroupEntity paramEmoticonFromGroupEntity)
  {
    int i = paramEmoticonFromGroupEntity.fromType;
    String str = null;
    Object localObject;
    if (1 == i)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFaceBitmap(4, paramEmoticonFromGroupEntity.troopUin, (byte)2, false, (byte)1, 0);
      str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonFromGroupEntity.troopUin, true);
      paramEmoticonFromGroupEntity = (EmoticonFromGroupEntity)localObject;
      localObject = str;
    }
    else if (3000 == paramEmoticonFromGroupEntity.fromType)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFaceBitmap(101, paramEmoticonFromGroupEntity.troopUin, (byte)3, false, (byte)1, 0);
      str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramEmoticonFromGroupEntity.troopUin);
      paramEmoticonFromGroupEntity = (EmoticonFromGroupEntity)localObject;
      localObject = str;
    }
    else
    {
      localObject = null;
      paramEmoticonFromGroupEntity = str;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramEmoticonFromGroupEntity);
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
  }
  
  private void a(EmoticonFromGroupEntity paramEmoticonFromGroupEntity, int paramInt1, int paramInt2)
  {
    AbstractGifImage.resumeAll();
    a(paramEmoticonFromGroupEntity);
    if (-1 != paramEmoticonFromGroupEntity.status)
    {
      if (paramEmoticonFromGroupEntity.status == 0)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131708160));
        this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#FFBBBBBB"));
        this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844470));
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131708161));
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#FFFFFFFF"));
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844469));
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    }
    if (this.e.containsKey(Integer.valueOf(paramInt2)))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreEmoticonGroupStoreFragment.titleRoot != this.jdField_a_of_type_AndroidViewView.getParent())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreEmoticonGroupStoreFragment.titleRoot.addView(this.jdField_a_of_type_AndroidViewView);
        this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreEmoticonGroupStoreFragment.a(false);
      }
      int i = 0;
      int k;
      for (int j = 0; i < paramInt2; j = k)
      {
        k = j;
        if (this.e.containsKey(Integer.valueOf(i))) {
          k = j + ((List)this.e.get(Integer.valueOf(i))).size();
        }
        i += 1;
      }
      this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setCurrentItem(j + paramInt1, false);
    }
    VasWebviewUtil.a("", "QLbq", "ClickPreview", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
  }
  
  private void b(EmoticonFromGroupEntity paramEmoticonFromGroupEntity)
  {
    if (paramEmoticonFromGroupEntity.status == 0)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131708166));
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#FFBBBBBB"));
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844470));
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131708164));
    this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#FFFFFFFF"));
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844469));
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
  }
  
  public String a(int paramInt)
  {
    String str = (String)this.d.get(Integer.valueOf(paramInt));
    return (String)this.jdField_b_of_type_JavaUtilMap.get(str);
  }
  
  public void a(Map<String, List<EmoticonFromGroupEntity>> paramMap, List<EmoticonFromGroupEntity> paramList)
  {
    this.jdField_a_of_type_JavaUtilMap = paramMap;
    this.e.clear();
    this.d.clear();
    this.c.clear();
    a();
    this.jdField_b_of_type_JavaUtilMap.clear();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (List)((Map.Entry)localObject).getValue();
      this.jdField_b_of_type_JavaUtilMap.put(str, this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIEmoticonFromGroupManager.a(str, ((List)localObject).size(), "  "));
    }
    notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreImgPreviewAdapter.a(paramList);
    this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreImgPreviewAdapter.notifyDataSetChanged();
  }
  
  public boolean a(boolean paramBoolean)
  {
    boolean bool = this.jdField_b_of_type_Boolean;
    this.jdField_b_of_type_Boolean = paramBoolean;
    return bool;
  }
  
  public int getItemCount()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilMap;
    int i = 0;
    int j = 0;
    if (localObject != null)
    {
      int k = ((Map)localObject).size();
      localObject = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      i = j;
      while (((Iterator)localObject).hasNext())
      {
        double d1 = ((List)((Map.Entry)((Iterator)localObject).next()).getValue()).size();
        Double.isNaN(d1);
        i += (int)Math.ceil(d1 / 3.0D);
      }
      i = k + i + 1;
    }
    return i;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == getItemCount() - 1) {
      return 2;
    }
    return ((Integer)this.c.get(Integer.valueOf(paramInt))).intValue();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof PicSelectAdapter.PicItemViewHolder))
    {
      PicSelectAdapter.PicItemViewHolder localPicItemViewHolder = (PicSelectAdapter.PicItemViewHolder)paramViewHolder;
      List localList = (List)this.e.get(Integer.valueOf(paramInt));
      int j = localList.size();
      int i = 0;
      while (i < 3)
      {
        RelativeLayout localRelativeLayout = (RelativeLayout)localPicItemViewHolder.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].getParent();
        if (i < j)
        {
          localRelativeLayout.setVisibility(0);
          localPicItemViewHolder.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIEmoticonFromGroupManager.a((EmoticonFromGroupEntity)localList.get(i), 65537, this.jdField_a_of_type_Int, null));
          this.jdField_b_of_type_Int = ((EmoticonFromGroupEntity)((List)this.e.get(Integer.valueOf(paramInt))).get(i)).status;
          if (this.jdField_b_of_type_Int == 0)
          {
            localPicItemViewHolder.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetNumberCheckBox[i].setVisibility(4);
            localPicItemViewHolder.b[i].setVisibility(0);
            paramViewHolder.itemView.setClickable(false);
          }
          else if (this.jdField_a_of_type_Boolean)
          {
            localPicItemViewHolder.b[i].setVisibility(4);
            if (this.jdField_b_of_type_Int > 0)
            {
              localPicItemViewHolder.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetNumberCheckBox[i].setVisibility(0);
              localPicItemViewHolder.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetNumberCheckBox[i].setCheckedNumber(this.jdField_b_of_type_Int);
            }
            else
            {
              localPicItemViewHolder.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetNumberCheckBox[i].setChecked(false);
              localPicItemViewHolder.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetNumberCheckBox[i].setVisibility(0);
            }
          }
          else
          {
            localPicItemViewHolder.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetNumberCheckBox[i].setVisibility(4);
            localPicItemViewHolder.b[i].setVisibility(4);
          }
        }
        else
        {
          localRelativeLayout.setVisibility(4);
        }
        i += 1;
      }
      paramViewHolder.itemView.setTag(Integer.valueOf(paramInt));
    }
    else if ((paramViewHolder instanceof PicSelectAdapter.DateItemViewHolder))
    {
      ((PicSelectAdapter.DateItemViewHolder)paramViewHolder).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)this.jdField_b_of_type_JavaUtilMap.get(this.d.get(Integer.valueOf(paramInt))));
    }
    else if ((paramViewHolder instanceof PicSelectAdapter.HintTxtViewholder))
    {
      ((PicSelectAdapter.HintTxtViewholder)paramViewHolder).jdField_a_of_type_AndroidWidgetTextView.setText("仅保留最新的300个聊天表情，\n更多表情请在消息记录中查找哦～");
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
        return new PicSelectAdapter.HintTxtViewholder(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561903, paramViewGroup, false));
      }
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561900, paramViewGroup, false);
      localObject = (RecyclerView.LayoutParams)paramViewGroup.getLayoutParams();
      ((RecyclerView.LayoutParams)localObject).height = this.jdField_a_of_type_Int;
      paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramViewGroup = new PicSelectAdapter.PicItemViewHolder(paramViewGroup);
      paramViewGroup.a(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter$OnImgClickListener);
      return paramViewGroup;
    }
    return new PicSelectAdapter.DateItemViewHolder(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561899, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.PicSelectAdapter
 * JD-Core Version:    0.7.0.1
 */