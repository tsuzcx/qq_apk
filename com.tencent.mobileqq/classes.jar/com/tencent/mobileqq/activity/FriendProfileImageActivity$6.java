package com.tencent.mobileqq.activity;

import android.os.AsyncTask;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.adapter.FriendProfileImageAdapter;
import com.tencent.widget.Gallery;

class FriendProfileImageActivity$6
  extends AsyncTask<Void, Void, Void>
{
  FriendProfileImageActivity$6(FriendProfileImageActivity paramFriendProfileImageActivity, FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo) {}
  
  protected Void a(Void... paramVarArgs)
  {
    this.b.c.a(this.a);
    return null;
  }
  
  protected void a(Void paramVoid)
  {
    this.b.c.a(this.b.k);
    this.b.a.setSelection(this.b.c.d());
    this.b.b.notifyDataSetChanged();
    if ((!this.b.m) && (this.b.l)) {
      this.b.f.setVisibility(0);
    }
    this.b.g.post(new FriendProfileImageActivity.6.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageActivity.6
 * JD-Core Version:    0.7.0.1
 */