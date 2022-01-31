import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class aqan
  extends aqae
{
  public apuf a;
  
  public aqan(apuf paramapuf)
  {
    this.a = paramapuf;
  }
  
  public int a(List<aqae> paramList)
  {
    int i = 0;
    if (i < paramList.size())
    {
      Object localObject1 = (aqae)paramList.get(i);
      Object localObject2;
      if ((localObject1 instanceof aqan))
      {
        localObject1 = ((aqan)localObject1).a;
        if ((!(localObject1 instanceof apxf)) || (!(this.a instanceof apxf))) {
          break label133;
        }
        localObject2 = ((apxf)localObject1).f;
        String str = ((apxf)this.a).f;
        if ((localObject2 != null) && (((String)localObject2).equals(str))) {}
        do
        {
          return i;
          localObject1 = ((apxf)localObject1).e;
          localObject2 = ((apxf)this.a).e;
        } while ((localObject1 != null) && (((String)localObject1).equals(localObject2)));
      }
      label133:
      label203:
      do
      {
        do
        {
          i += 1;
          break;
          if ((!(localObject1 instanceof apxv)) || (!(this.a instanceof apxv))) {
            break label203;
          }
          localObject1 = ((apxv)localObject1).a;
          localObject2 = ((apxv)this.a).a;
        } while ((localObject1 == null) || (localObject2 == null) || (((Emoticon)localObject1).eId == null) || (!((Emoticon)localObject1).eId.equals(((Emoticon)localObject2).eId)));
        return i;
      } while ((!(localObject1 instanceof aptr)) || (!(this.a instanceof aptr)) || (((aptr)localObject1).g != ((aptr)this.a).g));
      return i;
    }
    return 0;
  }
  
  public long a()
  {
    if ((this.a instanceof apxm)) {
      return ((apxm)this.a).a();
    }
    return 0L;
  }
  
  public Drawable a(Context paramContext)
  {
    URLDrawable localURLDrawable = null;
    if ((this.a instanceof apxv)) {
      localURLDrawable = ((apxv)this.a).a("fromAIO", true);
    }
    do
    {
      return localURLDrawable;
      if ((this.a instanceof apxf)) {
        return ((apxf)this.a).b(paramContext, paramContext.getResources().getDisplayMetrics().density, paramContext.getResources().getDisplayMetrics().widthPixels, paramContext.getResources().getDisplayMetrics().heightPixels);
      }
    } while (!(this.a instanceof aptr));
    return ((aptr)this.a).a(paramContext, paramContext.getResources().getDisplayMetrics().widthPixels, paramContext.getResources().getDisplayMetrics().heightPixels);
  }
  
  public apuf a()
  {
    return this.a;
  }
  
  public CustomEmotionData a()
  {
    if (((this.a instanceof apxf)) && (((apxf)this.a).g != null))
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = ((apon)((QQAppInterface)localObject).getManager(149)).a();
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            CustomEmotionData localCustomEmotionData = (CustomEmotionData)((Iterator)localObject).next();
            if (((apxf)this.a).g.equalsIgnoreCase(localCustomEmotionData.resid)) {
              return localCustomEmotionData;
            }
          }
        }
      }
    }
    return null;
  }
  
  public void a(Bundle paramBundle, int paramInt)
  {
    super.a(paramBundle, paramInt);
    paramBundle.putInt("cur_emotion_id", (int)a());
    if ((this.a instanceof aptr)) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramBundle.putInt("cur_emotion_type", paramInt);
      return;
    }
  }
  
  public boolean a()
  {
    return this.a instanceof apxv;
  }
  
  public boolean a(aqae paramaqae)
  {
    boolean bool = true;
    if ((paramaqae instanceof aqan))
    {
      paramaqae = ((aqan)paramaqae).a;
      Object localObject;
      if (((paramaqae instanceof apxf)) && ((this.a instanceof apxf)))
      {
        paramaqae = ((apxf)paramaqae).g;
        localObject = ((apxf)this.a).g;
        return (paramaqae != null) && (paramaqae.equals(localObject));
      }
      if (((paramaqae instanceof apxv)) && ((this.a instanceof apxv)))
      {
        paramaqae = ((apxv)paramaqae).a;
        localObject = ((apxv)this.a).a;
        if ((paramaqae != null) && (localObject != null) && (paramaqae.eId != null) && (paramaqae.eId.equals(((Emoticon)localObject).eId)) && (paramaqae.epId != null) && (paramaqae.epId.equals(((Emoticon)localObject).epId))) {}
        for (;;)
        {
          return bool;
          bool = false;
        }
      }
    }
    return false;
  }
  
  public aqae b(Bundle paramBundle)
  {
    if (paramBundle.containsKey("cur_emotion_id"))
    {
      QLog.d("FavEmoticonPreviewData", 1, "doRestoreSaveInstanceState");
      int i = paramBundle.getInt("cur_emotion_type");
      int j = paramBundle.getInt("cur_emotion_id");
      paramBundle = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramBundle instanceof QQAppInterface))
      {
        paramBundle = (QQAppInterface)paramBundle;
        if (i == 1) {}
        for (i = 333;; i = 149)
        {
          paramBundle = (apmi)paramBundle.getManager(i);
          Object localObject = paramBundle.a();
          if ((localObject == null) || (((List)localObject).isEmpty())) {
            break;
          }
          localObject = ((List)localObject).iterator();
          CustomEmotionBase localCustomEmotionBase;
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localCustomEmotionBase = (CustomEmotionBase)((Iterator)localObject).next();
          } while (localCustomEmotionBase.emoId != j);
          return new aqan(paramBundle.a(localCustomEmotionBase));
        }
      }
    }
    return null;
  }
  
  public boolean b()
  {
    return true;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public boolean d()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqan
 * JD-Core Version:    0.7.0.1
 */