package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class ContactBindedActivity$AddedAdapter
  extends BaseAdapter
  implements DecodeTaskCompletionListener
{
  private boolean b = false;
  private final Drawable c;
  private Context d;
  
  public ContactBindedActivity$AddedAdapter(ContactBindedActivity paramContactBindedActivity, Context paramContext)
  {
    this.c = paramContext.getResources().getDrawable(2130846389);
    this.d = paramContext;
  }
  
  public PhoneContact a(int paramInt)
  {
    return (PhoneContact)ContactBindedActivity.a(this.a).get(paramInt);
  }
  
  void a()
  {
    if (this.b)
    {
      if ((ContactBindedActivity.a(this.a) != null) && (ContactBindedActivity.a(this.a).size() > 0))
      {
        PhoneContact localPhoneContact = (PhoneContact)ContactBindedActivity.a(this.a).get(ContactBindedActivity.a(this.a).size() - 1);
        ContactBindedActivity.a(this.a, localPhoneContact, false);
      }
      this.b = false;
      return;
    }
    this.b = true;
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return ContactBindedActivity.a(this.a).size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    PhoneContact localPhoneContact = a(paramInt);
    Bitmap localBitmap = null;
    View localView = paramView;
    if (paramView == null) {
      localView = this.a.getLayoutInflater().inflate(2131625198, null);
    }
    localView.setTag(localPhoneContact);
    ImageView localImageView = (ImageView)localView.findViewById(2131432714);
    paramView = localBitmap;
    if (paramInt == getCount() - 1)
    {
      paramView = localBitmap;
      if (this.b) {
        paramView = this.c;
      }
    }
    localImageView.setImageDrawable(paramView);
    localBitmap = ContactBindedActivity.b(this.a).getBitmapFromCache(11, localPhoneContact.unifiedCode);
    paramView = localBitmap;
    if (localBitmap == null)
    {
      ContactBindedActivity.b(this.a).requestDecodeFace(localPhoneContact.unifiedCode, 11, true, (byte)0);
      paramView = ContactBindedActivity.c(this.a);
    }
    localImageView.setBackgroundDrawable(new BitmapDrawable(this.d.getResources(), paramView));
    if (AppSetting.e) {
      localImageView.setContentDescription(localPhoneContact.name);
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void notifyDataSetChanged()
  {
    this.b = false;
    super.notifyDataSetChanged();
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (ContactBindedActivity.d(this.a) == null) {
      return;
    }
    paramInt1 = 0;
    while (paramInt1 < ContactBindedActivity.d(this.a).getChildCount())
    {
      View localView = ContactBindedActivity.d(this.a).getChildAt(paramInt1);
      Object localObject = localView.getTag();
      if ((localObject != null) && ((localObject instanceof PhoneContact)) && (paramString.equals(((PhoneContact)localObject).unifiedCode))) {
        ((ImageView)localView.findViewById(2131432714)).setBackgroundDrawable(new BitmapDrawable(this.d.getResources(), paramBitmap));
      }
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ContactBindedActivity.AddedAdapter
 * JD-Core Version:    0.7.0.1
 */