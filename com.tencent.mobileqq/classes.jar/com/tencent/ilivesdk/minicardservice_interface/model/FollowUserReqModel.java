package com.tencent.ilivesdk.minicardservice_interface.model;

public class FollowUserReqModel
{
  public int clientType;
  public boolean isFollow;
  public long isPush;
  public long roomId;
  public int source;
  public CardServerUidInfo userUid;
  
  public int getAction()
  {
    if (this.isFollow) {
      return 1;
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.minicardservice_interface.model.FollowUserReqModel
 * JD-Core Version:    0.7.0.1
 */