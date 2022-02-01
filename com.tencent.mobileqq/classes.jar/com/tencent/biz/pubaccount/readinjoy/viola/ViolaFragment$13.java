package com.tencent.biz.pubaccount.readinjoy.viola;

import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil;
import com.tencent.mobileqq.colornote.ColorNoteCurd.OnColorNoteCurdListener;

class ViolaFragment$13
  extends ColorNoteCurd.OnColorNoteCurdListener
{
  ViolaFragment$13(ViolaFragment paramViolaFragment) {}
  
  public void onAddColorNote(Bundle paramBundle, boolean paramBoolean)
  {
    super.onAddColorNote(paramBundle, paramBoolean);
    int i = paramBundle.getInt("color_note_curd_from_type");
    if (ViolaFragment.access$300(this.a) != null)
    {
      ViolaFragment.access$300(this.a).a(i);
      ReportUtil.b(ViolaFragment.access$300(this.a).a());
    }
    if (i != 1) {
      ViolaFragment.access$500(this.a);
    }
  }
  
  public void onDeleteColorNote(int paramInt, String paramString, boolean paramBoolean)
  {
    super.onDeleteColorNote(paramInt, paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment.13
 * JD-Core Version:    0.7.0.1
 */