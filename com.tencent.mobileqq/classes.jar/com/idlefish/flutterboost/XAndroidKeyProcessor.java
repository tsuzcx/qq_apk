package com.idlefish.flutterboost;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel.FlutterKeyEvent;

public class XAndroidKeyProcessor
{
  private int combiningCharacter;
  @NonNull
  private final KeyEventChannel keyEventChannel;
  @NonNull
  private final XTextInputPlugin textInputPlugin;
  
  public XAndroidKeyProcessor(@NonNull KeyEventChannel paramKeyEventChannel, @NonNull XTextInputPlugin paramXTextInputPlugin)
  {
    this.keyEventChannel = paramKeyEventChannel;
    this.textInputPlugin = paramXTextInputPlugin;
  }
  
  @Nullable
  private Character applyCombiningCharacterToBaseCharacter(int paramInt)
  {
    Object localObject;
    if (paramInt == 0) {
      localObject = null;
    }
    Character localCharacter;
    do
    {
      return localObject;
      localCharacter = Character.valueOf((char)paramInt);
      int i;
      if ((0x80000000 & paramInt) != 0) {
        i = 1;
      }
      while (i != 0)
      {
        paramInt = 0x7FFFFFFF & paramInt;
        if (this.combiningCharacter != 0)
        {
          this.combiningCharacter = KeyCharacterMap.getDeadChar(this.combiningCharacter, paramInt);
          return localCharacter;
          i = 0;
        }
        else
        {
          this.combiningCharacter = paramInt;
          return localCharacter;
        }
      }
      localObject = localCharacter;
    } while (this.combiningCharacter == 0);
    paramInt = KeyCharacterMap.getDeadChar(this.combiningCharacter, paramInt);
    if (paramInt > 0) {
      localCharacter = Character.valueOf((char)paramInt);
    }
    this.combiningCharacter = 0;
    return localCharacter;
  }
  
  public void onKeyDown(@NonNull KeyEvent paramKeyEvent)
  {
    if ((this.textInputPlugin.getLastInputConnection() != null) && (this.textInputPlugin.getInputMethodManager().isAcceptingText())) {
      this.textInputPlugin.getLastInputConnection().sendKeyEvent(paramKeyEvent);
    }
    Character localCharacter = applyCombiningCharacterToBaseCharacter(paramKeyEvent.getUnicodeChar());
    this.keyEventChannel.keyDown(new KeyEventChannel.FlutterKeyEvent(paramKeyEvent, localCharacter));
  }
  
  public void onKeyUp(@NonNull KeyEvent paramKeyEvent)
  {
    Character localCharacter = applyCombiningCharacterToBaseCharacter(paramKeyEvent.getUnicodeChar());
    this.keyEventChannel.keyUp(new KeyEventChannel.FlutterKeyEvent(paramKeyEvent, localCharacter));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.idlefish.flutterboost.XAndroidKeyProcessor
 * JD-Core Version:    0.7.0.1
 */