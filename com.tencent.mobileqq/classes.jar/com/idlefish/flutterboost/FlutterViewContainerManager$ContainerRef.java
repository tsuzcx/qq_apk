package com.idlefish.flutterboost;

import com.idlefish.flutterboost.interfaces.IFlutterViewContainer;
import java.lang.ref.WeakReference;

public class FlutterViewContainerManager$ContainerRef
{
  public final WeakReference<IFlutterViewContainer> container;
  public final String uniqueId;
  
  FlutterViewContainerManager$ContainerRef(String paramString, IFlutterViewContainer paramIFlutterViewContainer)
  {
    this.uniqueId = paramString;
    this.container = new WeakReference(paramIFlutterViewContainer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.idlefish.flutterboost.FlutterViewContainerManager.ContainerRef
 * JD-Core Version:    0.7.0.1
 */