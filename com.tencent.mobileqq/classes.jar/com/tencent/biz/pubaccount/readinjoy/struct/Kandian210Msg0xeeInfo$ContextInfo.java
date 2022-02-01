package com.tencent.biz.pubaccount.readinjoy.struct;

import java.io.Serializable;
import java.util.ArrayList;

public class Kandian210Msg0xeeInfo$ContextInfo
  implements Serializable
{
  public String contextBrief;
  public long contextId;
  public String contextTitle;
  public int contextType;
  public String orangeWord;
  public String pictureJumpURL;
  public ArrayList<String> picturesURLList;
  public String videoBrief;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(", contextId=").append(this.contextId).append(", contextBrief='").append(this.contextBrief).append('\'').append(", contextTitle='").append(this.contextTitle).append('\'').append(", pictureJumpURL='").append(this.pictureJumpURL).append('\'').append(", orangeWord='").append(this.orangeWord).append('\'').append(", contextType=").append(this.contextType).append(", videoBrief='").append(this.videoBrief).append('\'').append(", picturesURLList='");
    if ((this.picturesURLList != null) && (this.picturesURLList.size() > 0)) {}
    for (String str = (String)this.picturesURLList.get(0);; str = "") {
      return str + '\'';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.Kandian210Msg0xeeInfo.ContextInfo
 * JD-Core Version:    0.7.0.1
 */