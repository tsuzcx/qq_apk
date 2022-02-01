package com.tencent.mobileqq.activity.activateFriend;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsObserver;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.ActivateFriendItem;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

public class ActivateFriendView
  extends LinearLayout
  implements DecodeTaskCompletionListener
{
  private static Bitmap d;
  private static final int e = ViewUtils.dpToPx(85.0F);
  private static final int f = ViewUtils.dpToPx(70.0F);
  private static final int g = ViewUtils.dpToPx(70.0F);
  private static final int h = ViewUtils.dpToPx(52.0F);
  ActivateFriendsManager a;
  FriendListObserver b = new ActivateFriendView.2(this);
  ActivateFriendsObserver c = new ActivateFriendView.3(this);
  private ArrayList<ActivateFriendItem> i = new ArrayList();
  private ArrayList<ActivateFriendViewItem> j = new ArrayList();
  private boolean k = true;
  private int l = 0;
  private boolean m = false;
  private boolean n = true;
  private ActivateFriendGrid.GridCallBack o = null;
  private IFaceDecoder p;
  private Hashtable<String, Bitmap> q = new Hashtable();
  private QQAppInterface r;
  private View.OnClickListener s = new ActivateFriendView.1(this);
  
  public ActivateFriendView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private Bitmap a(String paramString)
  {
    Bitmap localBitmap = this.p.getBitmapFromCache(1, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.p.isPausing()) {
      this.p.requestDecodeFace(paramString, 1, true, (byte)0);
    }
    return d;
  }
  
  public ActivateFriendViewItem a(int paramInt)
  {
    ActivateFriendViewItem localActivateFriendViewItem = new ActivateFriendViewItem(getContext(), this.m, this.n);
    addView(localActivateFriendViewItem, new LinearLayout.LayoutParams(paramInt, -2));
    return localActivateFriendViewItem;
  }
  
  public long[] getCheckedFriends()
  {
    long[] arrayOfLong = new long[this.l];
    int i1 = 0;
    int i3;
    for (int i2 = 0; i1 < this.j.size(); i2 = i3)
    {
      i3 = i2;
      if (((ActivateFriendViewItem)this.j.get(i1)).f)
      {
        arrayOfLong[i2] = ((ActivateFriendItem)this.i.get(i1)).uin;
        i3 = i2 + 1;
      }
      i1 += 1;
    }
    return arrayOfLong;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (!this.p.isPausing())
    {
      if (paramBitmap != null) {
        this.q.put(paramString, paramBitmap);
      }
      if (paramInt1 <= 0)
      {
        paramInt2 = this.j.size();
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          long l1 = ((ActivateFriendItem)this.i.get(paramInt1)).uin;
          paramString = (Bitmap)this.q.get(String.valueOf(l1));
          if (paramString != null) {
            ((ActivateFriendViewItem)this.j.get(paramInt1)).setHead(paramString);
          }
          paramInt1 += 1;
        }
        this.q.clear();
      }
    }
  }
  
  public void setCheckAbilityEnable(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void setData(QQAppInterface paramQQAppInterface, ArrayList<ActivateFriendItem> paramArrayList)
  {
    this.r = paramQQAppInterface;
    if (d == null) {
      d = ImageUtil.k();
    }
    this.i.clear();
    paramQQAppInterface = this.j.iterator();
    while (paramQQAppInterface.hasNext()) {
      removeView((ActivateFriendViewItem)paramQQAppInterface.next());
    }
    this.j.clear();
    this.i.addAll(paramArrayList);
    if (this.p == null)
    {
      this.p = ((IQQAvatarService)this.r.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.r);
      this.p.setDecodeTaskCompletionListener(this);
    }
    this.a = ((ActivateFriendsManager)this.r.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS));
    this.r.addObserver(this.b);
    this.r.registObserver(this.c);
    this.l = 0;
    int i3 = this.i.size();
    int i1 = -2;
    if (i3 != 2)
    {
      if (i3 != 3)
      {
        if (i3 != 4)
        {
          if (i3 == 5) {
            i1 = h;
          }
        }
        else {
          i1 = g;
        }
      }
      else {
        i1 = f;
      }
    }
    else {
      i1 = e;
    }
    int i2 = 0;
    while (i2 < i3)
    {
      paramQQAppInterface = a(i1);
      paramQQAppInterface.setBirthday(((ActivateFriendItem)this.i.get(i2)).birthdayDesc);
      paramArrayList = String.valueOf(((ActivateFriendItem)this.i.get(i2)).uin);
      if (!TextUtils.isEmpty(((ActivateFriendItem)this.i.get(i2)).nickName)) {
        paramQQAppInterface.setNickName(((ActivateFriendItem)this.i.get(i2)).nickName);
      } else {
        paramQQAppInterface.setNickName(ContactUtils.a(this.r, paramArrayList, true));
      }
      paramQQAppInterface.setHead(a(paramArrayList));
      if (this.k) {
        paramQQAppInterface.setOnClickListener(this.s);
      }
      if (this.k) {
        if ((!getResources().getString(2131886159).equals(((ActivateFriendItem)this.i.get(i2)).birthdayDesc)) && (!this.a.c(((ActivateFriendItem)this.i.get(i2)).uin, ((ActivateFriendItem)this.i.get(i2)).type)))
        {
          if ((!this.a.a(((ActivateFriendItem)this.i.get(i2)).uin, ((ActivateFriendItem)this.i.get(i2)).type)) && (!this.a.b(((ActivateFriendItem)this.i.get(i2)).uin, ((ActivateFriendItem)this.i.get(i2)).type)))
          {
            this.l += 1;
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
      this.j.add(paramQQAppInterface);
      i2 += 1;
    }
    paramQQAppInterface = this.o;
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(this.l);
    }
  }
  
  public void setGridCallBack(ActivateFriendGrid.GridCallBack paramGridCallBack)
  {
    this.o = paramGridCallBack;
  }
  
  public void setSkinable(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public void setTextScrolling(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateFriendView
 * JD-Core Version:    0.7.0.1
 */