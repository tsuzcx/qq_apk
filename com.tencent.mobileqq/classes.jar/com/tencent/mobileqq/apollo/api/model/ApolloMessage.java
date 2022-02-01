package com.tencent.mobileqq.apollo.api.model;

import java.io.Serializable;

public class ApolloMessage
  implements Serializable
{
  public String extStr;
  public int flag = 0;
  public int id = 0;
  public boolean isPlayed = false;
  public byte[] name = null;
  public int peer_status;
  public long peer_ts = 0L;
  public long peer_uin = 0L;
  public int sender_status;
  public long sender_ts = 0L;
  public int status;
  public byte[] text = null;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.model.ApolloMessage
 * JD-Core Version:    0.7.0.1
 */