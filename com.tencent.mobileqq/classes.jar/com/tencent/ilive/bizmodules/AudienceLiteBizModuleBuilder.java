package com.tencent.ilive.bizmodules;

import android.os.Bundle;
import com.tencent.ilive.base.bizmodule.BizModulesBuilder;
import com.tencent.ilive.base.bizmodule.BootBizModules;
import com.tencent.ilive.litepages.room.roomconfig.AudienceLiteEntBootModules;

public class AudienceLiteBizModuleBuilder
  implements BizModulesBuilder
{
  public BootBizModules build(Bundle paramBundle)
  {
    return new AudienceLiteEntBootModules();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.bizmodules.AudienceLiteBizModuleBuilder
 * JD-Core Version:    0.7.0.1
 */