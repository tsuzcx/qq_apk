package com.eclipsesource.v8.inspector;

public abstract interface V8InspectorDelegate
{
  public abstract void onResponse(String paramString);
  
  public abstract void waitFrontendMessageOnPause();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.v8.inspector.V8InspectorDelegate
 * JD-Core Version:    0.7.0.1
 */