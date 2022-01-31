package com.tencent.mobileqq.activity.chathistory;

import aciy;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import axwd;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;

public class TroopAIOImageEmptyFragment
  extends IphoneTitleBarFragment
{
  String a;
  String b;
  String c;
  
  public static void a(Activity paramActivity, String paramString1, @Nullable String paramString2, String paramString3)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("title", paramString1);
    if (paramString2 != null) {
      localIntent.putExtra("url", paramString2);
    }
    localIntent.putExtra("text", paramString3);
    PublicFragmentActivity.a(paramActivity, localIntent, TroopAIOImageEmptyFragment.class);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(this.a);
    if (!TextUtils.isEmpty(this.b))
    {
      paramLayoutInflater = this.mContentView.getContext().getResources();
      paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
      paramViewGroup.mRequestWidth = aciy.a(321.0F, paramLayoutInflater);
      paramViewGroup.mRequestHeight = aciy.a(200.0F, paramLayoutInflater);
      paramViewGroup.mLoadingDrawable = axwd.a;
      paramViewGroup.mFailedDrawable = axwd.a;
      paramLayoutInflater = URLDrawable.getDrawable(this.b, paramViewGroup);
      ((ImageView)this.mContentView.findViewById(2131311432)).setImageDrawable(paramLayoutInflater);
    }
    ((TextView)this.mContentView.findViewById(2131311233)).setText(this.c);
  }
  
  public int getContentLayoutId()
  {
    return 2131494739;
  }
  
  public void init(Bundle paramBundle)
  {
    super.init(paramBundle);
    this.a = paramBundle.getString("title");
    this.b = paramBundle.getString("url");
    this.c = paramBundle.getString("text");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.TroopAIOImageEmptyFragment
 * JD-Core Version:    0.7.0.1
 */