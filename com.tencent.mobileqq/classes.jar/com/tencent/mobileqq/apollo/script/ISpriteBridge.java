package com.tencent.mobileqq.apollo.script;

import com.tencent.mobileqq.data.MessageRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/script/ISpriteBridge;", "", "buildSpriteTask", "", "task", "Lcom/tencent/mobileqq/apollo/script/SpriteTaskParam;", "msg", "Lcom/tencent/mobileqq/data/MessageRecord;", "actionId", "", "from", "clear", "hasUnreadAction", "", "initSprite", "context", "Lcom/tencent/mobileqq/apollo/script/ISpriteContext;", "playAction", "sendMsg", "cmshow_api_release"}, k=1, mv={1, 1, 16})
public abstract interface ISpriteBridge
{
  public abstract void a(int paramInt, @NotNull MessageRecord paramMessageRecord);
  
  public abstract void a(@NotNull SpriteTaskParam paramSpriteTaskParam);
  
  public abstract void a(@NotNull MessageRecord paramMessageRecord);
  
  public abstract boolean a();
  
  public abstract void b(@NotNull SpriteTaskParam paramSpriteTaskParam);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.ISpriteBridge
 * JD-Core Version:    0.7.0.1
 */