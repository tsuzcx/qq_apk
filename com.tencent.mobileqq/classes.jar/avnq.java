import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class avnq
  extends avnp
{
  public avnq(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(avma paramavma)
  {
    return 1;
  }
  
  public View a(ViewGroup paramViewGroup, avma paramavma)
  {
    paramavma = (avnr)paramavma;
    paramViewGroup = LayoutInflater.from(this.a).inflate(2131561078, paramViewGroup, false);
    paramavma.g = ((TextView)paramViewGroup.findViewById(2131378975));
    paramavma.e = ((ImageView)paramViewGroup.findViewById(2131368739));
    paramavma.f = ((ImageView)paramViewGroup.findViewById(2131368844));
    return paramViewGroup;
  }
  
  public avma a()
  {
    return new avnr(this);
  }
  
  public String a(avma paramavma)
  {
    long l = ((avoa)((avnr)paramavma).a).jdField_b_of_type_Long;
    if (l % 1000L > 500L) {}
    for (l = (int)l / 1000 + 1;; l = (int)l / 1000) {
      return String.valueOf(l);
    }
  }
  
  public void d(avma paramavma)
  {
    avoa localavoa = (avoa)paramavma.a;
    if ((localavoa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry != null) && (localavoa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.publishState != 0))
    {
      avnl.a(this.a, localavoa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, 2);
      return;
    }
    super.d(paramavma);
  }
  
  public void f(avma paramavma)
  {
    avnr localavnr = (avnr)paramavma;
    avoa localavoa = (avoa)localavnr.a;
    paramavma = bdjl.a(this.a, localavnr.a.a, localavoa.n);
    int j;
    String str;
    File localFile;
    boolean bool;
    if (TextUtils.isEmpty(paramavma))
    {
      localavnr.g.setVisibility(8);
      j = xod.a(this.a, 180.0F);
      str = (String)localavnr.e.getTag(2131377396);
      if (localavoa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry == null) {
        break label544;
      }
      localFile = new File(localavoa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath + "");
      bool = localFile.exists();
    }
    for (;;)
    {
      Object localObject;
      int i;
      if (bool)
      {
        localObject = localavoa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath;
        paramavma = (avma)localObject;
        if (localavoa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoWidth <= 0) {
          break label539;
        }
        paramavma = (avma)localObject;
        if (localavoa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoHeight <= 0) {
          break label539;
        }
        i = localavoa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoHeight * j / localavoa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoWidth;
        paramavma = (avma)localObject;
      }
      for (;;)
      {
        label195:
        if (i * 3 > j * 4) {
          i = j * 4 / 3;
        }
        for (;;)
        {
          if (!TextUtils.equals(str, paramavma))
          {
            localavnr.e.setTag(2131377396, paramavma);
            localObject = (FrameLayout.LayoutParams)localavnr.e.getLayoutParams();
            if (localObject != null) {
              break label444;
            }
            localObject = new FrameLayout.LayoutParams(j, i);
            localavnr.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
          for (;;)
          {
            try
            {
              localObject = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.a.getResources().getDrawable(2130845013);
              ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.a.getResources().getDrawable(2130845013);
              if (!bool) {
                continue;
              }
              paramavma = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject);
              paramavma.setTag(bcuq.b(j, i, bcwh.a(this.a, 3.0F)));
              paramavma.setDecodeHandler(bcuq.e);
              localavnr.e.setImageDrawable(paramavma);
              return;
            }
            catch (Exception paramavma)
            {
              label444:
              localavnr.e.setImageDrawable(this.a.getResources().getDrawable(2130845013));
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.i("ShortVideoMomentItemBuilder", 1, paramavma.toString());
              return;
            }
            localavnr.g.setVisibility(0);
            if ((paramavma instanceof SpannableString)) {
              localavnr.g.setMovementMethod(LinkMovementMethod.getInstance());
            }
            localavnr.g.setText(paramavma);
            break;
            localObject = localavoa.jdField_a_of_type_JavaLangString;
            paramavma = (avma)localObject;
            if (localavoa.jdField_a_of_type_Int <= 0) {
              break label539;
            }
            paramavma = (avma)localObject;
            if (localavoa.jdField_b_of_type_Int <= 0) {
              break label539;
            }
            i = localavoa.jdField_b_of_type_Int * j / localavoa.jdField_a_of_type_Int;
            paramavma = (avma)localObject;
            break label195;
            if ((((FrameLayout.LayoutParams)localObject).width != j) || (((FrameLayout.LayoutParams)localObject).height != i))
            {
              ((FrameLayout.LayoutParams)localObject).width = j;
              ((FrameLayout.LayoutParams)localObject).height = i;
              localavnr.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
              continue;
              paramavma = URLDrawable.getDrawable(paramavma, (URLDrawable.URLDrawableOptions)localObject);
            }
          }
        }
        label539:
        i = j;
      }
      label544:
      bool = false;
      localFile = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avnq
 * JD-Core Version:    0.7.0.1
 */