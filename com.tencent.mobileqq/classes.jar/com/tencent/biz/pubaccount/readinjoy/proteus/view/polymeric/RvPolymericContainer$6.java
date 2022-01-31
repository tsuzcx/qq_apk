package com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import org.json.JSONArray;
import pbz;
import pcj;

public class RvPolymericContainer$6
  implements Runnable
{
  public RvPolymericContainer$6(pbz parampbz, JSONArray paramJSONArray) {}
  
  public void run()
  {
    pbz.a(this.this$0).setCellArray(pbz.a(this.this$0).getTemplateFactory(), this.a);
    pbz.a(this.this$0).notifyDataSetChanged();
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.RvPolymericContainer.6
 * JD-Core Version:    0.7.0.1
 */