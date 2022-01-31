package com.tencent.mobileqq.app.fms;

import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import java.io.Serializable;
import java.util.List;

public class FullMessageSearchResult$SearchResultItem
  implements Serializable
{
  public QQMessageFacade.Message lastMessage;
  public List<MessageRecord> secondPageList;
  public List<Long> secondPageMessageUniseq;
  public RecentUser user;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.fms.FullMessageSearchResult.SearchResultItem
 * JD-Core Version:    0.7.0.1
 */