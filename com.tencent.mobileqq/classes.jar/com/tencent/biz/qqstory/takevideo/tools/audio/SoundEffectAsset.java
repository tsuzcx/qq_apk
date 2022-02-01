package com.tencent.biz.qqstory.takevideo.tools.audio;

public class SoundEffectAsset
  extends AudioAsset
{
  long jdField_a_of_type_Long;
  private SoundEffectDecodeManager jdField_a_of_type_ComTencentBizQqstoryTakevideoToolsAudioSoundEffectDecodeManager;
  String jdField_a_of_type_JavaLangString;
  int g;
  
  public byte[] a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoToolsAudioSoundEffectDecodeManager == null) || (paramInt1 < this.jdField_a_of_type_Long) || (paramInt1 > this.jdField_a_of_type_Long + this.g) || (paramInt1 >= paramInt2)) {}
    long l1;
    long l2;
    long l3;
    long l4;
    long l5;
    long l6;
    do
    {
      return null;
      int i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoToolsAudioSoundEffectDecodeManager.a * this.jdField_a_of_type_ComTencentBizQqstoryTakevideoToolsAudioSoundEffectDecodeManager.c * this.jdField_a_of_type_ComTencentBizQqstoryTakevideoToolsAudioSoundEffectDecodeManager.b / 1000;
      l1 = paramInt1;
      l2 = this.jdField_a_of_type_Long;
      l3 = i;
      l4 = paramInt2;
      l5 = this.jdField_a_of_type_Long;
      l6 = i;
    } while (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoToolsAudioSoundEffectDecodeManager == null);
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoToolsAudioSoundEffectDecodeManager.a(this.jdField_a_of_type_JavaLangString, (l1 - l2) * l3, (l4 - l5) * l6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.tools.audio.SoundEffectAsset
 * JD-Core Version:    0.7.0.1
 */