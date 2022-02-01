package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.widget.TextView;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class VideoFeedsDebugDialog
  extends QQCustomDialog
{
  private TextView a;
  private TextView b;
  
  private String a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<configs>\n<interact_button_style>");
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return i + "</interact_button_style>\n</configs>";
    }
  }
  
  private void a()
  {
    this.a.setVisibility(8);
    this.b.setVisibility(8);
  }
  
  private void a(String paramString)
  {
    ((ClipboardManager)getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("article", paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsDebugDialog
 * JD-Core Version:    0.7.0.1
 */