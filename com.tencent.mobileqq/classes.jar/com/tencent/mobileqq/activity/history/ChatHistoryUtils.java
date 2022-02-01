package com.tencent.mobileqq.activity.history;

public class ChatHistoryUtils
{
  public static ChatHistoryBaseFragment a(int paramInt)
  {
    switch (paramInt)
    {
    case 2131364503: 
    default: 
      return new ChatHistoryC2CAllFragment();
    case 2131364511: 
      return new ChatHistoryBaseTenDocFragment();
    case 2131364510: 
      return new ChatHistoryTroopMemberFragment();
    case 2131364509: 
      return new ChatHistoryTroopMediaFragment();
    case 2131364508: 
      return new ChatHistoryTroopLinkFragment();
    case 2131364507: 
      return new ChatHistoryTroopFileFragment();
    case 2131364506: 
      return new ChatHistoryTroopEmotionFragment();
    case 2131364505: 
      return new ChatHistoryTroopDateFragment();
    case 2131364504: 
      return new ChatHistoryTroopAllFragment();
    case 2131364502: 
      return new ChatHistoryDatalineFileFragment();
    case 2131364501: 
      return new ChatHistoryBaseTenDocFragment();
    case 2131364500: 
      return new ChatHistoryC2CMediaFragment();
    case 2131364499: 
      return new ChatHistoryC2CLinkFragment();
    case 2131364498: 
      return new ChatHistoryC2CFileFragment();
    case 2131364497: 
      return new ChatHistoryC2CEmotionFragment();
    case 2131364496: 
      return new ChatHistoryC2CDateFragment();
    }
    return new ChatHistoryC2CAllFragment();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryUtils
 * JD-Core Version:    0.7.0.1
 */