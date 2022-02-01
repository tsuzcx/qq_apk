package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.CardObserver;

class ProfileLabelEditorActivity$1
  extends CardObserver
{
  ProfileLabelEditorActivity$1(ProfileLabelEditorActivity paramProfileLabelEditorActivity) {}
  
  protected void onCardLabelUpdate(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      this.a.setResult(-1);
      this.a.b(2131719453);
    }
    else
    {
      this.a.b(2131719451);
    }
    paramObject = this.a;
    paramObject.a = false;
    paramObject.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ProfileLabelEditorActivity.1
 * JD-Core Version:    0.7.0.1
 */