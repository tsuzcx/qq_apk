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
      this.a.b(2131917013);
    }
    else
    {
      this.a.b(2131917011);
    }
    paramObject = this.a;
    paramObject.h = false;
    paramObject.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ProfileLabelEditorActivity.1
 * JD-Core Version:    0.7.0.1
 */