package com.tencent.gprosdk;

public final class GProIdentityInstruction
{
  final String mInstructionText;
  final String mMemberListPreviewImg;
  final String mNoteText;
  final String mSampleIdentityDesc;
  final String mTextChannelPreviewImg;
  
  public GProIdentityInstruction(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.mInstructionText = paramString1;
    this.mNoteText = paramString2;
    this.mTextChannelPreviewImg = paramString3;
    this.mMemberListPreviewImg = paramString4;
    this.mSampleIdentityDesc = paramString5;
  }
  
  public String getInstructionText()
  {
    return this.mInstructionText;
  }
  
  public String getMemberListPreviewImg()
  {
    return this.mMemberListPreviewImg;
  }
  
  public String getNoteText()
  {
    return this.mNoteText;
  }
  
  public String getSampleIdentityDesc()
  {
    return this.mSampleIdentityDesc;
  }
  
  public String getTextChannelPreviewImg()
  {
    return this.mTextChannelPreviewImg;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProIdentityInstruction{mInstructionText=");
    localStringBuilder.append(this.mInstructionText);
    localStringBuilder.append(",mNoteText=");
    localStringBuilder.append(this.mNoteText);
    localStringBuilder.append(",mTextChannelPreviewImg=");
    localStringBuilder.append(this.mTextChannelPreviewImg);
    localStringBuilder.append(",mMemberListPreviewImg=");
    localStringBuilder.append(this.mMemberListPreviewImg);
    localStringBuilder.append(",mSampleIdentityDesc=");
    localStringBuilder.append(this.mSampleIdentityDesc);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProIdentityInstruction
 * JD-Core Version:    0.7.0.1
 */