package com.tencent.mobileqq.apollo.api.script;

import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/api/script/ISpriteBridge;", "", "buildSpriteTask", "", "task", "Lcom/tencent/mobileqq/apollo/api/script/SpriteTaskParam;", "msg", "Lcom/tencent/mobileqq/data/ChatMessage;", "actionId", "", "from", "Lcom/tencent/mobileqq/apollo/api/model/MessageForApollo;", "clear", "initSprite", "context", "Lcom/tencent/mobileqq/apollo/script/SpriteContext;", "playAction", "sendMsg", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface ISpriteBridge
{
  public abstract void a(int paramInt, @NotNull MessageForApollo paramMessageForApollo);
  
  public abstract void a(@NotNull MessageForApollo paramMessageForApollo);
  
  public abstract void a(@NotNull SpriteTaskParam paramSpriteTaskParam);
  
  public abstract void b(@NotNull SpriteTaskParam paramSpriteTaskParam);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.script.ISpriteBridge
 * JD-Core Version:    0.7.0.1
 */