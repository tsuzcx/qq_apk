package com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric;

import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.helper.RecycleViewAdapterHelper;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import org.json.JSONArray;

class RvPolymericContainer$6
  implements Runnable
{
  RvPolymericContainer$6(RvPolymericContainer paramRvPolymericContainer, JSONArray paramJSONArray) {}
  
  public void run()
  {
    RvPolymericContainer.a(this.this$0).setCellArray(RvPolymericContainer.a(this.this$0).getTemplateFactory(), this.a);
    RvPolymericContainer.a(this.this$0).notifyDataSetChanged();
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.RvPolymericContainer.6
 * JD-Core Version:    0.7.0.1
 */