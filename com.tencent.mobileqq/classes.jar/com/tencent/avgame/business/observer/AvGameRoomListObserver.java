package com.tencent.avgame.business.observer;

import com.tencent.avgame.gamelobby.data.AVGameLobbyCommonContentInfo;
import com.tencent.avgame.gamelobby.data.AVGameLobbyConstants.BannerInfo;
import com.tencent.avgame.gamelobby.data.AVGameLobbyConstants.RandomMatchInfo;
import com.tencent.avgame.gamelobby.data.AVGameLobbyRandomMatchContentInfo;
import com.tencent.avgame.gamelobby.data.AVGameLobbySurvivalContentInfo;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class AvGameRoomListObserver
  implements BusinessObserver
{
  public final String a;
  
  public AvGameRoomListObserver()
  {
    this.jdField_a_of_type_JavaLangString = "AvGameRoomListObserver";
  }
  
  private void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length == 6)
      {
        a(((Integer)paramObject[0]).intValue(), (String)paramObject[1], (RoomInfo)paramObject[2], (byte[])paramObject[3], ((Long)paramObject[4]).longValue(), ((Long)paramObject[5]).longValue());
        return;
      }
    }
    QLog.e("AvGameRoomListObserver", 2, "onUpdateJoinRoom 参数 个数异常");
    a(-1, "", null, null, -1L, 0L);
  }
  
  private void b(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length == 6)
      {
        b(((Integer)paramObject[0]).intValue(), (String)paramObject[1], (RoomInfo)paramObject[2], (byte[])paramObject[3], ((Long)paramObject[4]).longValue(), ((Long)paramObject[5]).longValue());
        return;
      }
    }
    QLog.e("AvGameRoomListObserver", 2, "onUpdateJoinRoom 参数 个数异常");
    b(-1, "", null, null, -1L, 0L);
  }
  
  private void c(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length == 7)
      {
        AvGameRoomListObserver.BatchGetGroupGameRoomListResult localBatchGetGroupGameRoomListResult = new AvGameRoomListObserver.BatchGetGroupGameRoomListResult(this);
        localBatchGetGroupGameRoomListResult.jdField_a_of_type_JavaLangString = ((String)paramObject[2]);
        localBatchGetGroupGameRoomListResult.jdField_a_of_type_JavaUtilList = ((List)paramObject[3]);
        localBatchGetGroupGameRoomListResult.jdField_a_of_type_Int = ((Integer)paramObject[4]).intValue();
        localBatchGetGroupGameRoomListResult.b = ((Integer)paramObject[5]).intValue();
        localBatchGetGroupGameRoomListResult.c = ((Integer)paramObject[6]).intValue();
        a(((Integer)paramObject[0]).intValue(), (String)paramObject[1], localBatchGetGroupGameRoomListResult);
        return;
      }
    }
    QLog.e("AvGameRoomListObserver", 2, "onUpdateGetGroupRoomList 参数个数异常");
    a(-1, "", null);
  }
  
  private void d(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length == 3)
      {
        a(((Integer)paramObject[0]).intValue(), (String)paramObject[1], (String)paramObject[2]);
        return;
      }
    }
    QLog.e("AvGameRoomListObserver", 2, "onUpdateReceiveGroupRoomChangePush 参数个数异常");
  }
  
  private void e(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length == 3)
      {
        b(((Integer)paramObject[0]).intValue(), (String)paramObject[1], (String)paramObject[2]);
        return;
      }
    }
    QLog.e("AvGameRoomListObserver", 2, "onUpdateDestroyAllGameRoom 参数个数异常");
  }
  
  private void f(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length == 2)
      {
        a(paramBoolean, (String)paramObject[0], ((Long)paramObject[1]).longValue());
        return;
      }
    }
    QLog.e("AvGameRoomListObserver", 2, "onUpdateGetGameShare 参数个数异常");
  }
  
  private void g(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length == 4)
      {
        a(paramBoolean, ((Long)paramObject[0]).longValue(), ((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), ((Long)paramObject[3]).longValue());
        return;
      }
    }
    QLog.e("AvGameRoomListObserver", 2, "onUpdateGetShareInviteBackflowInfo 参数个数异常");
  }
  
  protected void a() {}
  
  public void a(int paramInt, String paramString, AvGameRoomListObserver.BatchGetGroupGameRoomListResult paramBatchGetGroupGameRoomListResult) {}
  
  public void a(int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong1, long paramLong2) {}
  
  public void a(int paramInt, String paramString1, String paramString2) {}
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, String paramString) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, String paramString) {}
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3, long paramLong4) {}
  
  protected void a(boolean paramBoolean, long paramLong, List<AVGameLobbyConstants.BannerInfo> paramList, AVGameLobbyConstants.RandomMatchInfo paramRandomMatchInfo, List<AVGameLobbySurvivalContentInfo> paramList1, List<AVGameLobbyCommonContentInfo> paramList2, List<AVGameLobbyRandomMatchContentInfo> paramList3, int paramInt, String paramString) {}
  
  protected void a(boolean paramBoolean, long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString, long paramLong) {}
  
  public void b(int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong1, long paramLong2) {}
  
  public void b(int paramInt, String paramString1, String paramString2) {}
  
  protected void b(boolean paramBoolean, int paramInt, long paramLong) {}
  
  protected void b(boolean paramBoolean, long paramLong, int paramInt, String paramString) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
    case 16: 
      paramObject = (Object[])paramObject;
      if ((paramObject != null) && (paramObject.length > 2))
      {
        b(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
        return;
      }
      break;
    case 15: 
      paramObject = (Object[])paramObject;
      if ((paramObject != null) && (paramObject.length > 4))
      {
        a(paramBoolean, ((Long)paramObject[0]).longValue(), (byte[])paramObject[1], ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), (String)paramObject[4]);
        return;
      }
      break;
    case 14: 
      paramObject = (Object[])paramObject;
      if ((paramObject != null) && (paramObject.length > 1))
      {
        b(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Long)paramObject[1]).longValue());
        return;
      }
      break;
    case 13: 
      a();
      return;
    case 12: 
      paramObject = (Object[])paramObject;
      if ((paramObject != null) && (paramObject.length > 2))
      {
        a(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
        return;
      }
      QLog.e("AvGameRoomListObserver", 2, "AvGameRoomListHandler.TYPE_GAME_LOBBY_PK_RESERVE 参数个数异常");
      return;
    case 11: 
      paramObject = (Object[])paramObject;
      if ((paramObject != null) && (paramObject.length > 1))
      {
        a(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Long)paramObject[1]).longValue());
        return;
      }
      break;
    case 10: 
      if ((paramObject != null) && ((paramObject instanceof Object[])))
      {
        paramObject = (Object[])paramObject;
        if (paramObject.length == 8)
        {
          a(paramBoolean, ((Long)paramObject[0]).longValue(), (List)paramObject[1], (AVGameLobbyConstants.RandomMatchInfo)paramObject[2], (List)paramObject[3], (List)paramObject[4], (List)paramObject[5], ((Integer)paramObject[6]).intValue(), (String)paramObject[7]);
          return;
        }
      }
      QLog.e("AvGameRoomListObserver", 2, "AvGameRoomListHandler.TYPE_GAME_ENTRY_LOBBY_INFO 参数个数异常");
      return;
    case 9: 
      paramObject = (Object[])paramObject;
      if ((paramObject != null) && (paramObject.length > 2))
      {
        a(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
        return;
      }
      break;
    case 8: 
      paramObject = (Object[])paramObject;
      if ((paramObject != null) && (paramObject.length > 3))
      {
        a(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), (String)paramObject[3]);
        return;
      }
      break;
    case 7: 
      g(paramBoolean, paramObject);
      return;
    case 6: 
      f(paramBoolean, paramObject);
      return;
    case 5: 
      e(paramBoolean, paramObject);
      return;
    case 4: 
      d(paramBoolean, paramObject);
      return;
    case 3: 
      c(paramBoolean, paramObject);
      return;
    case 2: 
      b(paramBoolean, paramObject);
      return;
    case 1: 
      a(paramBoolean, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.business.observer.AvGameRoomListObserver
 * JD-Core Version:    0.7.0.1
 */