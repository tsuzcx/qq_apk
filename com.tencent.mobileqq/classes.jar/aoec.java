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

public class aoec
  extends aodt
{
  public anyh a;
  
  public aoec(anyh paramanyh)
  {
    this.a = paramanyh;
  }
  
  public int a(List<aodt> paramList)
  {
    int i = 0;
    if (i < paramList.size())
    {
      Object localObject1 = (aodt)paramList.get(i);
      Object localObject2;
      if ((localObject1 instanceof aoec))
      {
        localObject1 = ((aoec)localObject1).a;
        if ((!(localObject1 instanceof aoaz)) || (!(this.a instanceof aoaz))) {
          break label133;
        }
        localObject2 = ((aoaz)localObject1).e;
        String str = ((aoaz)this.a).e;
        if ((localObject2 != null) && (((String)localObject2).equals(str))) {}
        do
        {
          return i;
          localObject1 = ((aoaz)localObject1).d;
          localObject2 = ((aoaz)this.a).d;
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
          if ((!(localObject1 instanceof aobp)) || (!(this.a instanceof aobp))) {
            break label203;
          }
          localObject1 = ((aobp)localObject1).a;
          localObject2 = ((aobp)this.a).a;
        } while ((localObject1 == null) || (localObject2 == null) || (((Emoticon)localObject1).eId == null) || (!((Emoticon)localObject1).eId.equals(((Emoticon)localObject2).eId)));
        return i;
      } while ((!(localObject1 instanceof anxv)) || (!(this.a instanceof anxv)) || (((anxv)localObject1).g != ((anxv)this.a).g));
      return i;
    }
    return 0;
  }
  
  public long a()
  {
    if ((this.a instanceof aobg)) {
      return ((aobg)this.a).a();
    }
    return 0L;
  }
  
  public Drawable a(Context paramContext)
  {
    URLDrawable localURLDrawable = null;
    if ((this.a instanceof aobp)) {
      localURLDrawable = ((aobp)this.a).a("fromAIO", true);
    }
    do
    {
      return localURLDrawable;
      if ((this.a instanceof aoaz)) {
        return ((aoaz)this.a).b(paramContext, paramContext.getResources().getDisplayMetrics().density, paramContext.getResources().getDisplayMetrics().widthPixels, paramContext.getResources().getDisplayMetrics().heightPixels);
      }
    } while (!(this.a instanceof anxv));
    return ((anxv)this.a).a(paramContext, paramContext.getResources().getDisplayMetrics().widthPixels, paramContext.getResources().getDisplayMetrics().heightPixels);
  }
  
  public anyh a()
  {
    return this.a;
  }
  
  public CustomEmotionData a()
  {
    if (((this.a instanceof aoaz)) && (((aoaz)this.a).f != null))
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = ((answ)((QQAppInterface)localObject).getManager(149)).a();
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            CustomEmotionData localCustomEmotionData = (CustomEmotionData)((Iterator)localObject).next();
            if (((aoaz)this.a).f.equalsIgnoreCase(localCustomEmotionData.resid)) {
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
    if ((this.a instanceof anxv)) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramBundle.putInt("cur_emotion_type", paramInt);
      return;
    }
  }
  
  public boolean a()
  {
    return this.a instanceof aobp;
  }
  
  public boolean a(aodt paramaodt)
  {
    boolean bool = true;
    if ((paramaodt instanceof aoec))
    {
      paramaodt = ((aoec)paramaodt).a;
      Object localObject;
      if (((paramaodt instanceof aoaz)) && ((this.a instanceof aoaz)))
      {
        paramaodt = ((aoaz)paramaodt).f;
        localObject = ((aoaz)this.a).f;
        return (paramaodt != null) && (paramaodt.equals(localObject));
      }
      if (((paramaodt instanceof aobp)) && ((this.a instanceof aobp)))
      {
        paramaodt = ((aobp)paramaodt).a;
        localObject = ((aobp)this.a).a;
        if ((paramaodt != null) && (localObject != null) && (paramaodt.eId != null) && (paramaodt.eId.equals(((Emoticon)localObject).eId)) && (paramaodt.epId != null) && (paramaodt.epId.equals(((Emoticon)localObject).epId))) {}
        for (;;)
        {
          return bool;
          bool = false;
        }
      }
    }
    return false;
  }
  
  public aodt b(Bundle paramBundle)
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
          paramBundle = (anqr)paramBundle.getManager(i);
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
          return new aoec(paramBundle.a(localCustomEmotionBase));
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
 * Qualified Name:     aoec
 * JD-Core Version:    0.7.0.1
 */