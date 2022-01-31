package com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import org.json.JSONArray;
import pno;
import pny;

public class RvPolymericContainer$7
  implements Runnable
{
  public RvPolymericContainer$7(pno parampno, JSONArray paramJSONArray) {}
  
  public void run()
  {
    pno.a(this.this$0).setCellArray(pno.b(this.this$0).getTemplateFactory(), this.a);
    pno.a(this.this$0).notifyDataSetChanged();
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.RvPolymericContainer.7
 * JD-Core Version:    0.7.0.1
 */