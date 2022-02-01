package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParserWithHotReload;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParserWithHotReload.IHotReloadChangedObserver;

public class RIJProteusParserObserver
  implements ProteusParserWithHotReload.IHotReloadChangedObserver
{
  private ReadInJoyBaseAdapter a;
  
  public RIJProteusParserObserver(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    this.a = paramReadInJoyBaseAdapter;
  }
  
  public void a()
  {
    if (ProteusParserWithHotReload.getInstance().isSupportHotReload()) {
      ProteusParserWithHotReload.getInstance().addHotReloadChangedObserver(this);
    }
  }
  
  public void b()
  {
    if (ProteusParserWithHotReload.getInstance().isSupportHotReload()) {
      ProteusParserWithHotReload.getInstance().removeHotReloadChangedObserver(this);
    }
  }
  
  public void onHotReloadChanged(Context paramContext, String paramString1, String paramString2)
  {
    this.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJProteusParserObserver
 * JD-Core Version:    0.7.0.1
 */