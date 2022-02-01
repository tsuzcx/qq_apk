package com.tencent.mobileqq.apollo.screenshot;

import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloAvatarFileManager.OnGetFramePathListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class ApolloAvatarVideoProcessor$3
  implements ApolloAvatarFileManager.OnGetFramePathListener
{
  ApolloAvatarVideoProcessor$3(ApolloAvatarVideoProcessor paramApolloAvatarVideoProcessor) {}
  
  public void a(boolean paramBoolean, List<String> paramList, int paramInt)
  {
    if ((!paramBoolean) || (paramList == null) || (paramList.isEmpty()))
    {
      QLog.e("ApolloAvatarVideoProcessor", 1, "getFrameFilePath pic list is empty");
      if (ApolloAvatarVideoProcessor.a(this.a) != null) {
        ApolloAvatarVideoProcessor.a(this.a).a(false, ApolloAvatarVideoProcessor.a(this.a));
      }
    }
    String str;
    do
    {
      return;
      ApolloAvatarVideoProcessor.a(this.a, ApolloAvatarVideoProcessor.a(this.a, paramList));
      str = ApolloAvatarVideoProcessor.a(this.a, paramInt);
      if (str != null) {
        break;
      }
      QLog.e("ApolloAvatarVideoProcessor", 1, "exits due to videoDirPath null");
    } while (ApolloAvatarVideoProcessor.a(this.a) == null);
    ApolloAvatarVideoProcessor.a(this.a).a(false, ApolloAvatarVideoProcessor.a(this.a));
    return;
    ApolloAvatarVideoProcessor.a(this.a, new ArrayList());
    ApolloAvatarVideoProcessor.a(this.a).addAll(paramList);
    ApolloAvatarVideoProcessor.b(this.a, str);
    QLog.i("ApolloAvatarVideoProcessor", 1, "videoPath = " + str + ", cover path = " + ApolloAvatarVideoProcessor.a(this.a) + ", pic list size = " + ApolloAvatarVideoProcessor.a(this.a).size());
    ApolloAvatarVideoProcessor.a(this.a, ApolloAvatarVideoProcessor.a(this.a, 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.ApolloAvatarVideoProcessor.3
 * JD-Core Version:    0.7.0.1
 */