package com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import org.json.JSONArray;
import qwn;
import qwx;

public class RvPolymericContainer$6
  implements Runnable
{
  public RvPolymericContainer$6(qwn paramqwn, JSONArray paramJSONArray) {}
  
  public void run()
  {
    qwn.a(this.this$0).setCellArray(qwn.a(this.this$0).getTemplateFactory(), this.a);
    qwn.a(this.this$0).notifyDataSetChanged();
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.RvPolymericContainer.6
 * JD-Core Version:    0.7.0.1
 */