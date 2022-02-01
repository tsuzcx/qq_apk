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

public class asup
  extends asug
{
  public asmu a;
  
  public asup(asmu paramasmu)
  {
    this.a = paramasmu;
  }
  
  public int a(List<asug> paramList)
  {
    int i = 0;
    if (i < paramList.size())
    {
      Object localObject1 = (asug)paramList.get(i);
      Object localObject2;
      if ((localObject1 instanceof asup))
      {
        localObject1 = ((asup)localObject1).a;
        if ((!(localObject1 instanceof asqn)) || (!(this.a instanceof asqn))) {
          break label133;
        }
        localObject2 = ((asqn)localObject1).f;
        String str = ((asqn)this.a).f;
        if ((localObject2 != null) && (((String)localObject2).equals(str))) {}
        do
        {
          return i;
          localObject1 = ((asqn)localObject1).e;
          localObject2 = ((asqn)this.a).e;
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
          if ((!(localObject1 instanceof asre)) || (!(this.a instanceof asre))) {
            break label203;
          }
          localObject1 = ((asre)localObject1).a;
          localObject2 = ((asre)this.a).a;
        } while ((localObject1 == null) || (localObject2 == null) || (((Emoticon)localObject1).eId == null) || (!((Emoticon)localObject1).eId.equals(((Emoticon)localObject2).eId)));
        return i;
      } while ((!(localObject1 instanceof asmg)) || (!(this.a instanceof asmg)) || (((asmg)localObject1).g != ((asmg)this.a).g));
      return i;
    }
    return 0;
  }
  
  public long a()
  {
    if ((this.a instanceof asqv)) {
      return ((asqv)this.a).a();
    }
    return 0L;
  }
  
  public Drawable a(Context paramContext)
  {
    URLDrawable localURLDrawable = null;
    if ((this.a instanceof asre)) {
      localURLDrawable = ((asre)this.a).a("fromAIO", true);
    }
    do
    {
      return localURLDrawable;
      if ((this.a instanceof asqn)) {
        return ((asqn)this.a).b(paramContext, paramContext.getResources().getDisplayMetrics().density, paramContext.getResources().getDisplayMetrics().widthPixels, paramContext.getResources().getDisplayMetrics().heightPixels);
      }
    } while (!(this.a instanceof asmg));
    return ((asmg)this.a).a(paramContext, paramContext.getResources().getDisplayMetrics().widthPixels, paramContext.getResources().getDisplayMetrics().heightPixels);
  }
  
  public asmu a()
  {
    return this.a;
  }
  
  public CustomEmotionData a()
  {
    if (((this.a instanceof asqn)) && (((asqn)this.a).g != null))
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = ((ashc)((QQAppInterface)localObject).getManager(149)).a();
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            CustomEmotionData localCustomEmotionData = (CustomEmotionData)((Iterator)localObject).next();
            if (((asqn)this.a).g.equalsIgnoreCase(localCustomEmotionData.resid)) {
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
    if ((this.a instanceof asmg)) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramBundle.putInt("cur_emotion_type", paramInt);
      return;
    }
  }
  
  public boolean a()
  {
    return this.a instanceof asre;
  }
  
  public boolean a(asug paramasug)
  {
    boolean bool = true;
    if ((paramasug instanceof asup))
    {
      paramasug = ((asup)paramasug).a;
      Object localObject;
      if (((paramasug instanceof asqn)) && ((this.a instanceof asqn)))
      {
        paramasug = ((asqn)paramasug).g;
        localObject = ((asqn)this.a).g;
        return (paramasug != null) && (paramasug.equals(localObject));
      }
      if (((paramasug instanceof asre)) && ((this.a instanceof asre)))
      {
        paramasug = ((asre)paramasug).a;
        localObject = ((asre)this.a).a;
        if ((paramasug != null) && (localObject != null) && (paramasug.eId != null) && (paramasug.eId.equals(((Emoticon)localObject).eId)) && (paramasug.epId != null) && (paramasug.epId.equals(((Emoticon)localObject).epId))) {}
        for (;;)
        {
          return bool;
          bool = false;
        }
      }
    }
    return false;
  }
  
  public asug b(Bundle paramBundle)
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
          paramBundle = (ases)paramBundle.getManager(i);
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
          return new asup(paramBundle.a(localCustomEmotionBase));
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
 * Qualified Name:     asup
 * JD-Core Version:    0.7.0.1
 */