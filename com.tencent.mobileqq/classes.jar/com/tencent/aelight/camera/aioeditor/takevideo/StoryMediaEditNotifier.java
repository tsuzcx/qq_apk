package com.tencent.aelight.camera.aioeditor.takevideo;

import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class StoryMediaEditNotifier
{
  private List<StoryMediaEditNotifier.IEditListener> a = new LinkedList();
  
  public static StoryMediaEditNotifier a()
  {
    return StoryMediaEditNotifier.InstanceHolder.a;
  }
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((StoryMediaEditNotifier.IEditListener)localIterator.next()).b();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((StoryMediaEditNotifier.IEditListener)localIterator.next()).a(paramBoolean);
    }
  }
  
  public boolean a(@NonNull StoryMediaEditNotifier.IEditListener paramIEditListener)
  {
    return this.a.add(paramIEditListener);
  }
  
  public boolean b(@NonNull StoryMediaEditNotifier.IEditListener paramIEditListener)
  {
    return this.a.remove(paramIEditListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.StoryMediaEditNotifier
 * JD-Core Version:    0.7.0.1
 */