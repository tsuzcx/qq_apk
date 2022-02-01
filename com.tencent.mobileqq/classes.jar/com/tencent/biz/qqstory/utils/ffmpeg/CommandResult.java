package com.tencent.biz.qqstory.utils.ffmpeg;

class CommandResult
{
  boolean isDone;
  final String output;
  final boolean success;
  
  CommandResult(boolean paramBoolean, String paramString)
  {
    this.success = paramBoolean;
    this.output = paramString;
  }
  
  static CommandResult getDummyFailureResponse()
  {
    return new CommandResult(false, "");
  }
  
  static CommandResult getOutputFromProcess(Process paramProcess)
  {
    if (success(Integer.valueOf(paramProcess.exitValue()))) {}
    for (String str = Util.convertInputStreamToString(paramProcess.getInputStream());; str = Util.convertInputStreamToString(paramProcess.getErrorStream())) {
      return new CommandResult(success(Integer.valueOf(paramProcess.exitValue())), str);
    }
  }
  
  static boolean success(Integer paramInteger)
  {
    return (paramInteger != null) && (paramInteger.intValue() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.ffmpeg.CommandResult
 * JD-Core Version:    0.7.0.1
 */