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

public class aodx
  extends aodo
{
  public anyc a;
  
  public aodx(anyc paramanyc)
  {
    this.a = paramanyc;
  }
  
  public int a(List<aodo> paramList)
  {
    int i = 0;
    if (i < paramList.size())
    {
      Object localObject1 = (aodo)paramList.get(i);
      Object localObject2;
      if ((localObject1 instanceof aodx))
      {
        localObject1 = ((aodx)localObject1).a;
        if ((!(localObject1 instanceof aoau)) || (!(this.a instanceof aoau))) {
          break label133;
        }
        localObject2 = ((aoau)localObject1).e;
        String str = ((aoau)this.a).e;
        if ((localObject2 != null) && (((String)localObject2).equals(str))) {}
        do
        {
          return i;
          localObject1 = ((aoau)localObject1).d;
          localObject2 = ((aoau)this.a).d;
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
          if ((!(localObject1 instanceof aobk)) || (!(this.a instanceof aobk))) {
            break label203;
          }
          localObject1 = ((aobk)localObject1).a;
          localObject2 = ((aobk)this.a).a;
        } while ((localObject1 == null) || (localObject2 == null) || (((Emoticon)localObject1).eId == null) || (!((Emoticon)localObject1).eId.equals(((Emoticon)localObject2).eId)));
        return i;
      } while ((!(localObject1 instanceof anxq)) || (!(this.a instanceof anxq)) || (((anxq)localObject1).g != ((anxq)this.a).g));
      return i;
    }
    return 0;
  }
  
  public long a()
  {
    if ((this.a instanceof aobb)) {
      return ((aobb)this.a).a();
    }
    return 0L;
  }
  
  public Drawable a(Context paramContext)
  {
    URLDrawable localURLDrawable = null;
    if ((this.a instanceof aobk)) {
      localURLDrawable = ((aobk)this.a).a("fromAIO", true);
    }
    do
    {
      return localURLDrawable;
      if ((this.a instanceof aoau)) {
        return ((aoau)this.a).b(paramContext, paramContext.getResources().getDisplayMetrics().density, paramContext.getResources().getDisplayMetrics().widthPixels, paramContext.getResources().getDisplayMetrics().heightPixels);
      }
    } while (!(this.a instanceof anxq));
    return ((anxq)this.a).a(paramContext, paramContext.getResources().getDisplayMetrics().widthPixels, paramContext.getResources().getDisplayMetrics().heightPixels);
  }
  
  public anyc a()
  {
    return this.a;
  }
  
  public CustomEmotionData a()
  {
    if (((this.a instanceof aoau)) && (((aoau)this.a).f != null))
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = ((ansr)((QQAppInterface)localObject).getManager(149)).a();
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            CustomEmotionData localCustomEmotionData = (CustomEmotionData)((Iterator)localObject).next();
            if (((aoau)this.a).f.equalsIgnoreCase(localCustomEmotionData.resid)) {
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
    if ((this.a instanceof anxq)) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramBundle.putInt("cur_emotion_type", paramInt);
      return;
    }
  }
  
  public boolean a()
  {
    return this.a instanceof aobk;
  }
  
  public boolean a(aodo paramaodo)
  {
    boolean bool = true;
    if ((paramaodo instanceof aodx))
    {
      paramaodo = ((aodx)paramaodo).a;
      Object localObject;
      if (((paramaodo instanceof aoau)) && ((this.a instanceof aoau)))
      {
        paramaodo = ((aoau)paramaodo).f;
        localObject = ((aoau)this.a).f;
        return (paramaodo != null) && (paramaodo.equals(localObject));
      }
      if (((paramaodo instanceof aobk)) && ((this.a instanceof aobk)))
      {
        paramaodo = ((aobk)paramaodo).a;
        localObject = ((aobk)this.a).a;
        if ((paramaodo != null) && (localObject != null) && (paramaodo.eId != null) && (paramaodo.eId.equals(((Emoticon)localObject).eId)) && (paramaodo.epId != null) && (paramaodo.epId.equals(((Emoticon)localObject).epId))) {}
        for (;;)
        {
          return bool;
          bool = false;
        }
      }
    }
    return false;
  }
  
  public aodo b(Bundle paramBundle)
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
          paramBundle = (anqm)paramBundle.getManager(i);
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
          return new aodx(paramBundle.a(localCustomEmotionBase));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aodx
 * JD-Core Version:    0.7.0.1
 */