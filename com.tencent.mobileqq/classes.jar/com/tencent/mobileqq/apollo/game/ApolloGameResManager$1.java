package com.tencent.mobileqq.apollo.game;

import com.tencent.mobileqq.apollo.game.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.model.ApolloGameData;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.concurrent.ConcurrentHashMap;

final class ApolloGameResManager$1
  implements Runnable
{
  ApolloGameResManager$1(QQAppInterface paramQQAppInterface, StartCheckParam paramStartCheckParam) {}
  
  public void run()
  {
    Object localObject = (ApolloDaoManagerServiceImpl)this.a.getRuntimeService(IApolloDaoManagerService.class, "all");
    ((ApolloDaoManagerServiceImpl)localObject).readApolloGameVerFromFile(this.b.game.gameId);
    localObject = ((ApolloDaoManagerServiceImpl)localObject).getApolloGameVer();
    if ((localObject != null) && (((ConcurrentHashMap)localObject).containsKey(Integer.valueOf(this.b.game.gameId))))
    {
      localObject = (String)((ConcurrentHashMap)localObject).get(Integer.valueOf(this.b.game.gameId));
      ApolloGameUtil.a(this.a, this.b.game.gameId, (String)localObject);
    }
    ApolloGameUtil.a(this.b.gameId, this.b.viewMode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGameResManager.1
 * JD-Core Version:    0.7.0.1
 */