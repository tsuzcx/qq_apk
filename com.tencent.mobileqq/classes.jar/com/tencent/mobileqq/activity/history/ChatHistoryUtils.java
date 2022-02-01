package com.tencent.mobileqq.activity.history;

public class ChatHistoryUtils
{
  public static ChatHistoryBaseFragment a(int paramInt)
  {
    switch (paramInt)
    {
    case 2131364616: 
    default: 
      return new ChatHistoryC2CAllFragment();
    case 2131364608: 
      return new ChatHistoryC2CAllFragment();
    case 2131364611: 
      return new ChatHistoryC2CFileFragment();
    case 2131364613: 
      return new ChatHistoryC2CMediaFragment();
    case 2131364610: 
      return new ChatHistoryC2CEmotionFragment();
    case 2131364612: 
      return new ChatHistoryC2CLinkFragment();
    case 2131364614: 
      return new ChatHistoryBaseTenDocFragment();
    case 2131364609: 
      return new ChatHistoryC2CDateFragment();
    case 2131364617: 
      return new ChatHistoryTroopAllFragment();
    case 2131364622: 
      return new ChatHistoryTroopMediaFragment();
    case 2131364619: 
      return new ChatHistoryTroopEmotionFragment();
    case 2131364620: 
      return new ChatHistoryTroopFileFragment();
    case 2131364621: 
      return new ChatHistoryTroopLinkFragment();
    case 2131364624: 
      return new ChatHistoryBaseTenDocFragment();
    case 2131364618: 
      return new ChatHistoryTroopDateFragment();
    case 2131364623: 
      return new ChatHistoryTroopMemberFragment();
    }
    return new ChatHistoryDatalineFileFragment();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryUtils
 * JD-Core Version:    0.7.0.1
 */