package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public class WXEmojiPageSharedObject
  implements WXMediaMessage.IMediaObject
{
  private static final String TAG = "MicroMsg.SDK.WXEmojiSharedObject";
  public String desc;
  public String iconUrl;
  public int pageType;
  public String secondUrl;
  public int tid;
  public String title;
  public int type;
  public String url;
  
  public WXEmojiPageSharedObject() {}
  
  public WXEmojiPageSharedObject(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3, String paramString5)
  {
    this.tid = paramInt2;
    this.title = paramString1;
    this.desc = paramString2;
    this.iconUrl = paramString3;
    this.secondUrl = paramString4;
    this.pageType = paramInt3;
    this.url = paramString5;
    this.type = paramInt1;
  }
  
  public boolean checkArgs()
  {
    if ((d.h(this.title)) || (d.h(this.iconUrl)))
    {
      Log.e("MicroMsg.SDK.WXEmojiSharedObject", "checkArgs fail, title or iconUrl is invalid");
      return false;
    }
    return true;
  }
  
  public void serialize(Bundle paramBundle)
  {
    paramBundle.putInt("_wxemojisharedobject_tid", this.tid);
    paramBundle.putString("_wxemojisharedobject_title", this.title);
    paramBundle.putString("_wxemojisharedobject_desc", this.desc);
    paramBundle.putString("_wxemojisharedobject_iconurl", this.iconUrl);
    paramBundle.putString("_wxemojisharedobject_secondurl", this.secondUrl);
    paramBundle.putInt("_wxemojisharedobject_pagetype", this.pageType);
    paramBundle.putString("_wxwebpageobject_url", this.url);
  }
  
  public int type()
  {
    return this.type;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    this.tid = paramBundle.getInt("_wxemojisharedobject_tid");
    this.title = paramBundle.getString("_wxemojisharedobject_title");
    this.desc = paramBundle.getString("_wxemojisharedobject_desc");
    this.iconUrl = paramBundle.getString("_wxemojisharedobject_iconurl");
    this.secondUrl = paramBundle.getString("_wxemojisharedobject_secondurl");
    this.pageType = paramBundle.getInt("_wxemojisharedobject_pagetype");
    this.url = paramBundle.getString("_wxwebpageobject_url");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXEmojiPageSharedObject
 * JD-Core Version:    0.7.0.1
 */