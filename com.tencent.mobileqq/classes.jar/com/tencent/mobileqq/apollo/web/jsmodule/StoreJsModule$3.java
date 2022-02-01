package com.tencent.mobileqq.apollo.web.jsmodule;

import com.tencent.mobileqq.apollo.web.ipc.IStoreAvatar2D.WriteLocalCallback;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

class StoreJsModule$3
  implements IStoreAvatar2D.WriteLocalCallback
{
  StoreJsModule$3(StoreJsModule paramStoreJsModule, String paramString) {}
  
  public void a(@Nullable JSONObject paramJSONObject)
  {
    Object localObject;
    if (paramJSONObject == null)
    {
      this.b.a(this.a, "写入失败");
    }
    else
    {
      localObject = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append("&&");
      localStringBuilder.append(this.a);
      localStringBuilder.append("(");
      localStringBuilder.append(paramJSONObject.toString());
      localStringBuilder.append(");");
      ((StoreJsModule)localObject).d(localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("IPC_APOLLO_WRITE_LOCAL onResponse data is:");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      QLog.d("[cmshow]StoreJsModule", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.StoreJsModule.3
 * JD-Core Version:    0.7.0.1
 */