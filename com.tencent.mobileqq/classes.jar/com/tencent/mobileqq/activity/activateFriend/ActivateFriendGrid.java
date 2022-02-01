package com.tencent.mobileqq.activity.activateFriend;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsObserver;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.ActivateFriendItem;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

public class ActivateFriendGrid
  extends FrameLayout
  implements DecodeTaskCompletionListener
{
  private static Bitmap d;
  private static int e = 15;
  private static int f = 14;
  ActivateFriendsManager a;
  FriendListObserver b = new ActivateFriendGrid.2(this);
  ActivateFriendsObserver c = new ActivateFriendGrid.3(this);
  private ArrayList<ActivateFriendItem> g = new ArrayList();
  private ArrayList<ActivateFriendGridItem> h = new ArrayList();
  private boolean i = true;
  private int j = 0;
  private boolean k = false;
  private boolean l = true;
  private int m;
  private int n;
  private ActivateFriendGrid.GridCallBack o = null;
  private ActivateFriendGrid.GridItemClickCallBack p = null;
  private IFaceDecoder q;
  private Hashtable<String, Bitmap> r = new Hashtable();
  private QQAppInterface s;
  private View.OnClickListener t = new ActivateFriendGrid.1(this);
  
  public ActivateFriendGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private int a(int paramInt)
  {
    int i1 = this.h.size();
    paramInt = 0;
    if (i1 > 0) {
      paramInt = ((ActivateFriendGridItem)this.h.get(0)).getMeasuredHeight();
    }
    return paramInt * 2 + 1 * DisplayUtil.a(getContext(), e);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if (paramInt2 < 3) {
      return paramInt2;
    }
    if (paramInt1 < 3) {
      return 3;
    }
    return paramInt2 - 3;
  }
  
  private Bitmap a(String paramString)
  {
    Bitmap localBitmap = this.q.getBitmapFromCache(1, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.q.isPausing()) {
      this.q.requestDecodeFace(paramString, 1, true, (byte)0);
    }
    return d;
  }
  
  public ActivateFriendGridItem a()
  {
    ActivateFriendGridItem localActivateFriendGridItem = new ActivateFriendGridItem(getContext(), this.k, this.l);
    addView(localActivateFriendGridItem, new FrameLayout.LayoutParams(-2, -2));
    return localActivateFriendGridItem;
  }
  
  public void b()
  {
    Object localObject = this.q;
    if (localObject != null)
    {
      ((IFaceDecoder)localObject).destory();
      this.q = null;
    }
    localObject = this.s;
    if (localObject != null)
    {
      ((QQAppInterface)localObject).removeObserver(this.b);
      this.s.unRegistObserver(this.c);
    }
  }
  
  public long[] getCheckedFriends()
  {
    long[] arrayOfLong = new long[this.j];
    int i1 = 0;
    int i3;
    for (int i2 = 0; i1 < this.h.size(); i2 = i3)
    {
      i3 = i2;
      if (((ActivateFriendGridItem)this.h.get(i1)).f)
      {
        arrayOfLong[i2] = ((ActivateFriendItem)this.g.get(i1)).uin;
        i3 = i2 + 1;
      }
      i1 += 1;
    }
    return arrayOfLong;
  }
  
  public String[] getCheckedFriendsTimeThisYear()
  {
    String[] arrayOfString = new String[this.j];
    StringBuilder localStringBuilder1 = new StringBuilder(" ActivateFriendGrid friendsBirth:");
    int i1 = 0;
    int i3;
    for (int i2 = 0; i1 < this.h.size(); i2 = i3)
    {
      i3 = i2;
      if (((ActivateFriendGridItem)this.h.get(i1)).f)
      {
        long l1 = ((ActivateFriendItem)this.g.get(i1)).birthSendTime;
        Object localObject1 = new Time();
        ((Time)localObject1).set(l1 * 1000L);
        i3 = ((Time)localObject1).month;
        int i4 = ((Time)localObject1).monthDay;
        ((Time)localObject1).setToNow();
        int i5 = ((Time)localObject1).year;
        int i6 = ((Time)localObject1).month;
        if (i4 < 10) {
          localObject1 = "-0";
        } else {
          localObject1 = "-";
        }
        Object localObject2;
        if (i3 < 9) {
          localObject2 = "-0";
        } else {
          localObject2 = "-";
        }
        if ((i3 == 0) && (i6 == 11))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(i5 + 1);
          ((StringBuilder)localObject2).append("-0");
          ((StringBuilder)localObject2).append(i3 + 1);
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(i4);
          arrayOfString[i2] = ((StringBuilder)localObject2).toString();
        }
        else if ((i3 == 11) && (i6 == 0))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(i5 - 1);
          ((StringBuilder)localObject2).append("-");
          ((StringBuilder)localObject2).append(i3 + 1);
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(i4);
          arrayOfString[i2] = ((StringBuilder)localObject2).toString();
        }
        else
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(i5);
          localStringBuilder2.append((String)localObject2);
          localStringBuilder2.append(i3 + 1);
          localStringBuilder2.append((String)localObject1);
          localStringBuilder2.append(i4);
          arrayOfString[i2] = localStringBuilder2.toString();
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(arrayOfString[i2]);
        ((StringBuilder)localObject1).append("|");
        localStringBuilder1.append(((StringBuilder)localObject1).toString());
        i3 = i2 + 1;
      }
      i1 += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriendGrid", 2, new Object[] { localStringBuilder1 });
    }
    return arrayOfString;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (!this.q.isPausing())
    {
      if (paramBitmap != null) {
        this.r.put(paramString, paramBitmap);
      }
      if (paramInt1 <= 0)
      {
        paramInt2 = this.h.size();
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          long l1 = ((ActivateFriendItem)this.g.get(paramInt1)).uin;
          paramString = (Bitmap)this.r.get(String.valueOf(l1));
          if (paramString != null) {
            ((ActivateFriendGridItem)this.h.get(paramInt1)).setHead(paramString);
          }
          paramInt1 += 1;
        }
        this.r.clear();
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = this.h.size();
    if (i1 > 3) {
      paramInt2 = 2;
    } else {
      paramInt2 = 1;
    }
    paramInt3 = 0;
    paramInt1 = 0;
    while (paramInt3 < i1)
    {
      int i5 = a(paramInt3, i1);
      ActivateFriendGridItem localActivateFriendGridItem = (ActivateFriendGridItem)this.h.get(paramInt3);
      int i2 = localActivateFriendGridItem.getMeasuredHeight();
      int i3 = localActivateFriendGridItem.getMeasuredWidth();
      paramInt4 = paramInt3 / 3;
      int i4 = paramInt3 % 3;
      if (i4 == 0)
      {
        if (this.h.size() > 0) {
          paramInt1 = ((ActivateFriendGridItem)this.h.get(0)).getMeasuredWidth();
        } else {
          paramInt1 = 0;
        }
        paramInt1 *= i5;
        int i6 = DisplayUtil.a(getContext(), f);
        int i7 = i5 - 1;
        int i8 = this.m;
        if (i6 * i7 + paramInt1 > i8)
        {
          paramInt1 = (i8 - paramInt1) / (i5 + 2);
          f = paramInt1;
        }
        else
        {
          paramInt1 = (i8 - paramInt1 - DisplayUtil.a(getContext(), f) * i7) / 2;
        }
      }
      if (paramInt2 > 1) {
        paramInt4 = paramInt4 * i2 + paramInt4 * DisplayUtil.a(getContext(), e);
      } else {
        paramInt4 = this.n / 2 - i2 / 2;
      }
      i4 = i4 * i3 + paramInt1 + i4 * DisplayUtil.a(getContext(), f);
      localActivateFriendGridItem.layout(i4, paramInt4, i3 + i4, i2 + paramInt4);
      paramInt3 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.m = getMeasuredWidth();
    this.n = a(paramInt2);
    setMeasuredDimension(getMeasuredWidth(), this.n);
  }
  
  public void setCheckAbilityEnable(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setData(QQAppInterface paramQQAppInterface, ArrayList<ActivateFriendItem> paramArrayList)
  {
    this.s = paramQQAppInterface;
    if (d == null) {
      d = ImageUtil.k();
    }
    this.g.clear();
    paramQQAppInterface = this.h.iterator();
    while (paramQQAppInterface.hasNext()) {
      removeView((ActivateFriendGridItem)paramQQAppInterface.next());
    }
    this.h.clear();
    this.g.addAll(paramArrayList);
    if (this.q == null)
    {
      this.q = ((IQQAvatarService)this.s.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.s);
      this.q.setDecodeTaskCompletionListener(this);
    }
    this.a = ((ActivateFriendsManager)this.s.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS));
    this.s.addObserver(this.b);
    this.s.registObserver(this.c);
    this.j = 0;
    int i2 = this.g.size();
    int i1 = 0;
    while (i1 < i2)
    {
      paramQQAppInterface = a();
      paramQQAppInterface.setIndex(i1);
      paramQQAppInterface.setBirthday(((ActivateFriendItem)this.g.get(i1)).birthdayDesc);
      paramQQAppInterface.setCheckViewGone();
      paramArrayList = String.valueOf(((ActivateFriendItem)this.g.get(i1)).uin);
      if (!TextUtils.isEmpty(((ActivateFriendItem)this.g.get(i1)).nickName)) {
        paramQQAppInterface.setNickName(((ActivateFriendItem)this.g.get(i1)).nickName);
      } else {
        paramQQAppInterface.setNickName(ContactUtils.a(this.s, paramArrayList, true));
      }
      paramQQAppInterface.setHead(a(paramArrayList));
      if (this.i) {
        paramQQAppInterface.setOnClickListener(this.t);
      }
      if (this.i) {
        if ((!getResources().getString(2131886159).equals(((ActivateFriendItem)this.g.get(i1)).birthdayDesc)) && (!this.a.c(((ActivateFriendItem)this.g.get(i1)).uin, ((ActivateFriendItem)this.g.get(i1)).type)))
        {
          if ((!this.a.a(((ActivateFriendItem)this.g.get(i1)).uin, ((ActivateFriendItem)this.g.get(i1)).type)) && (!this.a.b(((ActivateFriendItem)this.g.get(i1)).uin, ((ActivateFriendItem)this.g.get(i1)).type)))
          {
            this.j += 1;
            paramQQAppInterface.setChecked(true);
          }
          else
          {
            paramQQAppInterface.setChecked(false);
            paramQQAppInterface.setBirthday(getResources().getString(2131886162));
          }
        }
        else
        {
          paramQQAppInterface.setChecked(false);
          paramQQAppInterface.setBirthday(getResources().getString(2131886159));
        }
      }
      this.h.add(paramQQAppInterface);
      i1 += 1;
    }
    paramQQAppInterface = this.o;
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(this.j);
    }
  }
  
  public void setGridCallBack(ActivateFriendGrid.GridCallBack paramGridCallBack)
  {
    this.o = paramGridCallBack;
  }
  
  public void setGridItemClickCallBack(ActivateFriendGrid.GridItemClickCallBack paramGridItemClickCallBack)
  {
    this.p = paramGridItemClickCallBack;
  }
  
  public void setSkinable(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void setTextScrolling(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid
 * JD-Core Version:    0.7.0.1
 */