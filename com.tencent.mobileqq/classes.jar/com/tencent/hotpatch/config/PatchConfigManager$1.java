package com.tencent.hotpatch.config;

import java.util.Comparator;

final class PatchConfigManager$1
  implements Comparator<PatchConfig>
{
  public int a(PatchConfig paramPatchConfig1, PatchConfig paramPatchConfig2)
  {
    if ((paramPatchConfig1 == null) && (paramPatchConfig2 == null)) {}
    do
    {
      return 0;
      if ((paramPatchConfig1 == null) && (paramPatchConfig2 != null)) {
        return 1;
      }
      if ((paramPatchConfig1 != null) && (paramPatchConfig2 == null)) {
        return -1;
      }
      if (paramPatchConfig1.a() > paramPatchConfig2.a()) {
        return -1;
      }
    } while (paramPatchConfig1.a() >= paramPatchConfig2.a());
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.hotpatch.config.PatchConfigManager.1
 * JD-Core Version:    0.7.0.1
 */