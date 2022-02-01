package com.tencent.mobileqq.activity.miniaio;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.activity.recent.RecentParcelUtil;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public class MiniMsgTabAdapter
  extends BaseAdapter
  implements View.OnClickListener, DecodeTaskCompletionListener
{
  protected final ArrayList<RecentBaseData> a = new ArrayList(99);
  protected XListView b = null;
  protected RecentFaceDecoder c = new RecentFaceDecoder(paramQQAppInterface, this, false);
  MiniMsgTabFragment.OnItemClickListener d;
  private QQAppInterface e;
  private Context f;
  private long g = 0L;
  private MiniMsgTabDafultItemBulder h = new MiniMsgTabDafultItemBulder();
  private Hashtable<String, Bitmap> i = new Hashtable();
  
  public MiniMsgTabAdapter(QQAppInterface paramQQAppInterface, Context paramContext, XListView paramXListView, MiniMsgTabFragment.OnItemClickListener paramOnItemClickListener)
  {
    this.f = paramContext;
    this.e = paramQQAppInterface;
    this.b = paramXListView;
    this.d = paramOnItemClickListener;
  }
  
  protected View a()
  {
    return View.inflate(this.f, 2131625377, null);
  }
  
  public RecentBaseData a(View paramView)
  {
    if ((paramView != null) && ((paramView.getTag(-1) instanceof Integer)))
    {
      paramView = getItem(((Integer)paramView.getTag(-1)).intValue());
      if ((paramView instanceof RecentBaseData)) {
        return (RecentBaseData)paramView;
      }
    }
    return null;
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Drawable paramDrawable)
  {
    if (paramView != null)
    {
      if (paramRecentBaseData == null) {
        return;
      }
      Drawable localDrawable = paramDrawable;
      if (paramDrawable == null)
      {
        RecentFaceDecoder localRecentFaceDecoder = this.c;
        localDrawable = paramDrawable;
        if (localRecentFaceDecoder != null) {
          localDrawable = localRecentFaceDecoder.a(paramRecentBaseData.getRecentUserType(), paramRecentBaseData.getRecentUserUin());
        }
      }
      paramDrawable = this.h;
      if (paramDrawable != null) {
        try
        {
          paramDrawable.a(paramView, paramRecentBaseData, this.f, localDrawable);
          return;
        }
        catch (Throwable paramView)
        {
          if (!RecentParcelUtil.c(this.f)) {
            return;
          }
          throw new RuntimeException(paramView);
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = this.c;
    if (localObject != null) {
      ((RecentFaceDecoder)localObject).a(paramQQAppInterface);
    }
    if (this.e != paramQQAppInterface)
    {
      this.e = paramQQAppInterface;
      a(null);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onAccountChanged: invoked. Message: app: ");
      ((StringBuilder)localObject).append(paramQQAppInterface);
      QLog.i("MiniMsgTabAdapter", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(List<RecentBaseData> paramList)
  {
    this.a.clear();
    if (paramList != null)
    {
      int j = -1;
      try
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          RecentBaseData localRecentBaseData = (RecentBaseData)paramList.next();
          if (localRecentBaseData != null)
          {
            j += 1;
            if ((localRecentBaseData instanceof RecentItemChatMsgData)) {
              localRecentBaseData.mPosition = j;
            }
            this.a.add(localRecentBaseData);
          }
          else if (QLog.isColorLevel())
          {
            QLog.i("MiniMsgTabAdapter", 2, "setDataList, [item is null]");
          }
        }
        if (this.a.size() <= 0) {
          break label127;
        }
      }
      catch (Exception paramList)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MiniMsgTabAdapter", 2, paramList, new Object[0]);
        }
      }
    }
    else
    {
      this.b.setVisibility(0);
      break label141;
    }
    label127:
    if (QLog.isColorLevel()) {
      QLog.i("MiniMsgTabAdapter", 2, "setDataList, size = 0");
    }
    label141:
    notifyDataSetChanged();
  }
  
  public void b()
  {
    RecentFaceDecoder localRecentFaceDecoder = this.c;
    if (localRecentFaceDecoder != null) {
      localRecentFaceDecoder.b();
    }
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt >= 0) {
      try
      {
        if (paramInt < this.a.size())
        {
          Object localObject = this.a.get(paramInt);
          return localObject;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MiniMsgTabAdapter", 2, localException.toString());
        }
      }
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    RecentBaseData localRecentBaseData = (RecentBaseData)getItem(paramInt);
    int j = 0;
    paramInt = j;
    if (localRecentBaseData != null)
    {
      paramInt = j;
      if (localRecentBaseData.getRecentUserUin().equals(Integer.valueOf(0))) {
        paramInt = 1;
      }
    }
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = paramView;
    try
    {
      Object localObject3 = getItem(paramInt);
      localObject2 = paramView;
      localObject1 = paramView;
      if (!(localObject3 instanceof RecentBaseData)) {
        break label148;
      }
      localObject2 = paramView;
      localObject1 = (RecentBaseData)localObject3;
      localObject2 = paramView;
      if (((RecentBaseData)localObject1).getRecentUserUin().equals("0"))
      {
        localObject1 = paramView;
        if (paramView == null)
        {
          localObject2 = paramView;
          localObject1 = a();
          localObject2 = localObject1;
          ((View)localObject1).setTag(-1, Integer.valueOf(paramInt));
          localObject2 = localObject1;
          ((View)localObject1).setOnClickListener(this);
        }
      }
      else
      {
        localObject2 = paramView;
        localObject1 = this.h.a(paramInt, localObject1, this.c, paramView, paramViewGroup, this.f, this, null, null);
      }
    }
    catch (Throwable paramView)
    {
      RecentParcelUtil.a(this.f, false, paramView);
      if (RecentParcelUtil.c(this.f)) {
        break label166;
      }
    }
    Object localObject1 = localObject2;
    label148:
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return localObject1;
    label166:
    throw new RuntimeException(paramView);
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag(-1);
    if (!(localObject1 instanceof Integer))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("MiniMsgTabAdapter", 4, "RecentAdpater onClick tag is not int");
      }
    }
    else
    {
      localObject1 = getItem(((Integer)localObject1).intValue());
      if ((localObject1 instanceof RecentBaseData))
      {
        localObject1 = (RecentBaseData)localObject1;
        if (QLog.isDevelopLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("mTitleName");
          ((StringBuilder)localObject2).append(((RecentBaseData)localObject1).mTitleName);
          ((StringBuilder)localObject2).append(", msgSummary ");
          ((StringBuilder)localObject2).append(((RecentBaseData)localObject1).mLastMsg);
          QLog.i("MiniMsgTabAdapter", 2, ((StringBuilder)localObject2).toString());
        }
        Object localObject2 = this.d;
        if (localObject2 != null)
        {
          ((MiniMsgTabFragment.OnItemClickListener)localObject2).a((RecentBaseData)localObject1);
          ((RecentBaseData)localObject1).clearUnReadNum();
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    Object localObject2;
    long l1;
    boolean bool1;
    boolean bool2;
    if (this.b != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if ((paramBitmap == null) && (paramInt1 > 0)) {
        return;
      }
      if (paramBitmap != null) {
        try
        {
          Hashtable localHashtable = this.i;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramInt2);
          ((StringBuilder)localObject2).append(":");
          ((StringBuilder)localObject2).append(paramString);
          localHashtable.put(((StringBuilder)localObject2).toString(), paramBitmap);
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          System.gc();
          localOutOfMemoryError.printStackTrace();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onDecodeTaskCompleted error:");
          ((StringBuilder)localObject2).append(localOutOfMemoryError.getMessage());
          QLog.i("MiniMsgTabAdapter", 1, ((StringBuilder)localObject2).toString());
        }
      }
      l1 = System.currentTimeMillis();
      long l2 = this.g;
      if ((l2 > 0L) && (l1 - l2 > 300L)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("RecentAdapter.onDecodeTaskCompleted type=");
        ((StringBuilder)???).append(paramInt2);
        ((StringBuilder)???).append(", uin=");
        ((StringBuilder)???).append(paramString);
        ((StringBuilder)???).append(", remainingTasks=");
        ((StringBuilder)???).append(paramInt1);
        ((StringBuilder)???).append(", isdecodeFaceTimeout=");
        ((StringBuilder)???).append(bool1);
        ((StringBuilder)???).append(", avatar == null ? | ");
        if (paramBitmap == null) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        ((StringBuilder)???).append(bool2);
        QLog.d("MiniMsgTabAdapter", 2, ((StringBuilder)???).toString());
      }
      if ((paramInt1 > 0) && (!bool1)) {
        return;
      }
    }
    for (;;)
    {
      synchronized (this.i)
      {
        if (this.i.size() == 0) {
          return;
        }
        if (paramInt1 == 0) {
          this.g = 0L;
        } else {
          this.g = l1;
        }
        paramInt2 = this.b.getChildCount();
        paramInt1 = 0;
        bool1 = false;
        if (paramInt1 < paramInt2)
        {
          localObject2 = this.b.getChildAt(paramInt1);
          RecentBaseData localRecentBaseData = a((View)localObject2);
          if (localRecentBaseData == null)
          {
            bool2 = bool1;
            break label772;
          }
          int j = localRecentBaseData.getRecentUserType();
          paramString = localRecentBaseData.getRecentUserUin();
          j = ((Integer)RecentFaceDecoder.a(this.e, j, paramString).first).intValue();
          bool2 = bool1;
          if (j == -2147483648) {
            break label772;
          }
          paramBitmap = new StringBuilder();
          paramBitmap.append(j);
          paramBitmap.append(":");
          paramBitmap.append(paramString);
          paramString = paramBitmap.toString();
          paramString = (Bitmap)this.i.get(paramString);
          bool2 = bool1;
          if (paramString == null) {
            break label772;
          }
          if (j == 103)
          {
            l1 = System.currentTimeMillis();
            paramBitmap = BaseApplication.getContext().getResources().getDrawable(2130841165);
            if ((paramBitmap instanceof SkinnableBitmapDrawable)) {
              ((SkinnableBitmapDrawable)paramBitmap).setGravity(81);
            }
            if ((paramBitmap instanceof BitmapDrawable)) {
              ((BitmapDrawable)paramBitmap).setGravity(81);
            }
            paramBitmap.setBounds(0, 0, paramBitmap.getIntrinsicWidth(), paramBitmap.getIntrinsicHeight());
            paramBitmap = new LayerDrawable(new Drawable[] { new BitmapDrawable(BaseApplication.getContext().getResources(), paramString), paramBitmap });
            paramString = paramBitmap;
            if (QLog.isDevelopLevel())
            {
              paramString = new StringBuilder();
              paramString.append("onDecodeTaskCompleted, subaccount cost = ");
              paramString.append(System.currentTimeMillis() - l1);
              QLog.i("MiniMsgTabAdapter", 4, paramString.toString());
              paramString = paramBitmap;
            }
          }
          else
          {
            paramString = new BitmapDrawable(BaseApplication.getContext().getResources(), paramString);
          }
          a((View)localObject2, localRecentBaseData, paramString);
          bool2 = true;
          break label772;
        }
        if (QLog.isDevelopLevel())
        {
          paramString = new StringBuilder();
          paramString.append("decodecomplete|faceCache size = ");
          paramString.append(this.i.size());
          paramString.append(", isNeedUpdateAvatar=");
          paramString.append(bool1);
          QLog.i("MiniMsgTabAdapter", 4, paramString.toString());
        }
        this.i.clear();
        return;
      }
      return;
      label772:
      paramInt1 += 1;
      bool1 = bool2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniMsgTabAdapter
 * JD-Core Version:    0.7.0.1
 */