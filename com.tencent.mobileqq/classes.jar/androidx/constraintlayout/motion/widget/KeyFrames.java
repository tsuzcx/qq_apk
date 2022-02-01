package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class KeyFrames
{
  private static final String TAG = "KeyFrames";
  public static final int UNSET = -1;
  static HashMap<String, Constructor<? extends Key>> sKeyMakers = new HashMap();
  private HashMap<Integer, ArrayList<Key>> mFramesMap = new HashMap();
  
  static
  {
    try
    {
      sKeyMakers.put("KeyAttribute", KeyAttributes.class.getConstructor(new Class[0]));
      sKeyMakers.put("KeyPosition", KeyPosition.class.getConstructor(new Class[0]));
      sKeyMakers.put("KeyCycle", KeyCycle.class.getConstructor(new Class[0]));
      sKeyMakers.put("KeyTimeCycle", KeyTimeCycle.class.getConstructor(new Class[0]));
      sKeyMakers.put("KeyTrigger", KeyTrigger.class.getConstructor(new Class[0]));
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Log.e("KeyFrames", "unable to load", localNoSuchMethodException);
    }
  }
  
  public KeyFrames(Context paramContext, XmlPullParser paramXmlPullParser)
  {
    Object localObject1 = null;
    int i;
    try
    {
      i = paramXmlPullParser.getEventType();
    }
    catch (IOException paramContext)
    {
      String str;
      boolean bool;
      paramContext.printStackTrace();
      return;
    }
    catch (XmlPullParserException paramContext)
    {
      paramContext.printStackTrace();
    }
    Object localObject2 = localObject1;
    if ("KeyFrameSet".equals(paramXmlPullParser.getName()))
    {
      return;
      label47:
      str = paramXmlPullParser.getName();
      bool = sKeyMakers.containsKey(str);
      if (bool)
      {
        try
        {
          localObject2 = (Key)((Constructor)sKeyMakers.get(str)).newInstance(new Object[0]);
          try
          {
            ((Key)localObject2).load(paramContext, Xml.asAttributeSet(paramXmlPullParser));
            addKey((Key)localObject2);
          }
          catch (Exception localException1)
          {
            localObject1 = localObject2;
          }
          Log.e("KeyFrames", "unable to create ", localException2);
        }
        catch (Exception localException2) {}
        localObject2 = localObject1;
      }
      else
      {
        localObject2 = localObject1;
        if (localException2.equalsIgnoreCase("CustomAttribute"))
        {
          localObject2 = localObject1;
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            if (localObject1.mCustomConstraints != null)
            {
              ConstraintAttribute.parse(paramContext, paramXmlPullParser, localObject1.mCustomConstraints);
              localObject2 = localObject1;
            }
          }
        }
      }
    }
    for (;;)
    {
      i = paramXmlPullParser.next();
      localObject1 = localObject2;
      while (i == 1) {
        return;
      }
      localObject2 = localObject1;
      if (i != 0)
      {
        if (i == 2) {
          break label47;
        }
        if (i == 3) {
          break;
        }
        localObject2 = localObject1;
      }
    }
  }
  
  private void addKey(Key paramKey)
  {
    if (!this.mFramesMap.containsKey(Integer.valueOf(paramKey.mTargetId))) {
      this.mFramesMap.put(Integer.valueOf(paramKey.mTargetId), new ArrayList());
    }
    ((ArrayList)this.mFramesMap.get(Integer.valueOf(paramKey.mTargetId))).add(paramKey);
  }
  
  static String name(int paramInt, Context paramContext)
  {
    return paramContext.getResources().getResourceEntryName(paramInt);
  }
  
  public void addFrames(MotionController paramMotionController)
  {
    Object localObject = (ArrayList)this.mFramesMap.get(Integer.valueOf(paramMotionController.mId));
    if (localObject != null) {
      paramMotionController.addKeys((ArrayList)localObject);
    }
    localObject = (ArrayList)this.mFramesMap.get(Integer.valueOf(-1));
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Key localKey = (Key)((Iterator)localObject).next();
        if (localKey.matches(((ConstraintLayout.LayoutParams)paramMotionController.mView.getLayoutParams()).constraintTag)) {
          paramMotionController.addKey(localKey);
        }
      }
    }
  }
  
  public ArrayList<Key> getKeyFramesForView(int paramInt)
  {
    return (ArrayList)this.mFramesMap.get(Integer.valueOf(paramInt));
  }
  
  public Set<Integer> getKeys()
  {
    return this.mFramesMap.keySet();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.KeyFrames
 * JD-Core Version:    0.7.0.1
 */