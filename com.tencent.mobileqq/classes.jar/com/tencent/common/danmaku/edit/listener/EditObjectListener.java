package com.tencent.common.danmaku.edit.listener;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/common/danmaku/edit/listener/EditObjectListener;", "", "addRichEditObjectFailed", "", "editObject", "Lcom/tencent/common/danmaku/edit/bean/EditObject;", "extraInfo", "Lorg/json/JSONObject;", "onRichEditObjectChanged", "isAdd", "", "type", "", "id", "", "qqdanmaku_release"}, k=1, mv={1, 1, 16})
public abstract interface EditObjectListener
{
  public abstract void a(boolean paramBoolean, int paramInt, @NotNull String paramString, @Nullable JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.edit.listener.EditObjectListener
 * JD-Core Version:    0.7.0.1
 */