package com.tencent.mobileqq.activity;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;

public class ShieldFriendsListActivity
  extends IphoneTitleBarActivity
  implements DecodeTaskCompletionListener
{
  FriendListObserver a = new ShieldFriendsListActivity.2(this);
  private TextView b;
  private XListView c;
  private IFaceDecoder d;
  private ShieldFriendsListActivity.ShieldFriendsAdapter e;
  
  private void a()
  {
    ThreadManager.excute(new ShieldFriendsListActivity.1(this), 16, null, true);
  }
  
  private boolean a(long paramLong, boolean paramBoolean)
  {
    int j = this.c.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = this.c.getChildAt(i);
      if (localObject != null)
      {
        localObject = (ShieldFriendsListActivity.Holder)((View)localObject).getTag();
        if ((localObject != null) && (paramLong == Long.valueOf(((ShieldFriendsListActivity.Holder)localObject).d).longValue()))
        {
          if (((ShieldFriendsListActivity.Holder)localObject).c.isChecked() != paramBoolean)
          {
            ((ShieldFriendsListActivity.Holder)localObject).c.setOnCheckedChangeListener(null);
            ((ShieldFriendsListActivity.Holder)localObject).c.setChecked(paramBoolean);
            ((ShieldFriendsListActivity.Holder)localObject).c.setOnCheckedChangeListener(((ShieldFriendsListActivity.Holder)localObject).e);
          }
          return true;
        }
      }
      i += 1;
    }
    return false;
  }
  
  private void b()
  {
    if (this.e.getCount() <= 0)
    {
      this.c.setVisibility(8);
      this.b.setVisibility(0);
      return;
    }
    this.c.setVisibility(0);
    this.b.setVisibility(8);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131627851);
    super.setTitle(2131897288);
    this.c = ((XListView)super.findViewById(2131437317));
    this.b = ((TextView)super.findViewById(2131433225));
    this.b.setText(2131897289);
    this.b.setBackgroundDrawable(null);
    this.b.setTextSize(2, 17.0F);
    this.b.setTextColor(getResources().getColor(2131168263));
    paramBundle = new RelativeLayout.LayoutParams(-2, -2);
    paramBundle.addRule(13);
    this.b.setLayoutParams(paramBundle);
    this.d = ((IQQAvatarService)this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
    this.d.setDecodeTaskCompletionListener(this);
    this.e = new ShieldFriendsListActivity.ShieldFriendsAdapter(this, this.d, this.app);
    this.c.setAdapter(this.e);
    paramBundle = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
    paramBundle.topMargin = ((int)DisplayUtils.a(this, 12.0F));
    this.c.setLayoutParams(paramBundle);
    a();
    addObserver(this.a);
    if (AppSetting.e) {
      this.leftView.setContentDescription(HardCodeUtil.a(2131901576));
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    IFaceDecoder localIFaceDecoder = this.d;
    if (localIFaceDecoder != null) {
      localIFaceDecoder.destory();
    }
    removeObserver(this.a);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("uin=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", type=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(",avatar= ");
      ((StringBuilder)localObject).append(paramBitmap);
      QLog.d("ShieldFriendsListActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBitmap == null) {
      return;
    }
    paramInt2 = this.c.getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      localObject = this.c.getChildAt(paramInt1);
      if (localObject != null)
      {
        localObject = (ShieldFriendsListActivity.Holder)((View)localObject).getTag();
        if ((localObject != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(((ShieldFriendsListActivity.Holder)localObject).d)))
        {
          ((ShieldFriendsListActivity.Holder)localObject).a.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
          return;
        }
      }
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ShieldFriendsListActivity
 * JD-Core Version:    0.7.0.1
 */