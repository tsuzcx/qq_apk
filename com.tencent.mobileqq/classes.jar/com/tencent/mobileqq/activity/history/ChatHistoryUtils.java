package com.tencent.mobileqq.activity.history;

public class ChatHistoryUtils
{
  public static ChatHistoryBaseFragment a(int paramInt)
  {
    switch (paramInt)
    {
    case 2131430560: 
    default: 
      return new ChatHistoryC2CAllFragment();
    case 2131430568: 
      return new ChatHistoryBaseTenDocFragment();
    case 2131430567: 
      return new ChatHistoryTroopMemberFragment();
    case 2131430566: 
      return new ChatHistoryTroopMediaFragment();
    case 2131430565: 
      return new ChatHistoryTroopLinkFragment();
    case 2131430564: 
      return new ChatHistoryTroopFileFragment();
    case 2131430563: 
      return new ChatHistoryTroopEmotionFragment();
    case 2131430562: 
      return new ChatHistoryTroopDateFragment();
    case 2131430561: 
      return new ChatHistoryTroopAllFragment();
    case 2131430559: 
      return new ChatHistoryDatalineFileFragment();
    case 2131430558: 
      return new ChatHistoryBaseTenDocFragment();
    case 2131430557: 
      return new ChatHistoryC2CMediaFragment();
    case 2131430556: 
      return new ChatHistoryC2CLinkFragment();
    case 2131430555: 
      return new ChatHistoryC2CFileFragment();
    case 2131430554: 
      return new ChatHistoryC2CEmotionFragment();
    case 2131430553: 
      return new ChatHistoryC2CDateFragment();
    }
    return new ChatHistoryC2CAllFragment();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryUtils
 * JD-Core Version:    0.7.0.1
 */