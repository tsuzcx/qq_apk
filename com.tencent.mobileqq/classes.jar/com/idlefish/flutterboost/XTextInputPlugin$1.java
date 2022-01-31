package com.idlefish.flutterboost;

import io.flutter.embedding.engine.systemchannels.TextInputChannel.Configuration;
import io.flutter.embedding.engine.systemchannels.TextInputChannel.TextEditState;
import io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler;

class XTextInputPlugin$1
  implements TextInputChannel.TextInputMethodHandler
{
  XTextInputPlugin$1(XTextInputPlugin paramXTextInputPlugin) {}
  
  public void clearClient()
  {
    XTextInputPlugin.access$600(this.this$0);
  }
  
  public void hide()
  {
    XTextInputPlugin.access$200(this.this$0, XTextInputPlugin.access$000(this.this$0));
  }
  
  public void setClient(int paramInt, TextInputChannel.Configuration paramConfiguration)
  {
    XTextInputPlugin.access$300(this.this$0, paramInt, paramConfiguration);
  }
  
  public void setEditingState(TextInputChannel.TextEditState paramTextEditState)
  {
    XTextInputPlugin.access$500(this.this$0, XTextInputPlugin.access$000(this.this$0), paramTextEditState);
  }
  
  public void setPlatformViewClient(int paramInt)
  {
    XTextInputPlugin.access$400(this.this$0, paramInt);
  }
  
  public void show()
  {
    XTextInputPlugin.access$100(this.this$0, XTextInputPlugin.access$000(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.idlefish.flutterboost.XTextInputPlugin.1
 * JD-Core Version:    0.7.0.1
 */