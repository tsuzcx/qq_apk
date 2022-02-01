package com.tencent.biz.pubaccount.readinjoy.view.headers;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.search.HotWordSearchEntryModel.OnGifPlayListener;

class ReadInJoyTabTopSearchHeaderController$2
  implements HotWordSearchEntryModel.OnGifPlayListener
{
  ReadInJoyTabTopSearchHeaderController$2(ReadInJoyTabTopSearchHeaderController paramReadInJoyTabTopSearchHeaderController) {}
  
  public void a()
  {
    ReadInJoyTabTopSearchHeaderController.a(this.a).setVisibility(8);
    ReadInJoyTabTopSearchHeaderController.b(this.a).setVisibility(8);
  }
  
  public void b()
  {
    ReadInJoyTabTopSearchHeaderController.a(this.a, false);
    ReadInJoyTabTopSearchHeaderController.a(this.a, 3);
    this.a.a();
    PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit().putLong("search_hotword_show_lasttime", System.currentTimeMillis()).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyTabTopSearchHeaderController.2
 * JD-Core Version:    0.7.0.1
 */