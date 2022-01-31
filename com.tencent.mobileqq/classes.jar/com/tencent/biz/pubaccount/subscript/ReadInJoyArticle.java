package com.tencent.biz.pubaccount.subscript;

import java.io.Serializable;

public class ReadInJoyArticle
  implements Serializable
{
  public static final String TAG = "ReadInJoyArticle";
  public long mArticleID = -1L;
  public String mArticleUrl = "";
  public long mChannelID = -1L;
  public String mFirstPagePicUrl = "";
  public String mSummary = "";
  public String mTitle = "";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.ReadInJoyArticle
 * JD-Core Version:    0.7.0.1
 */