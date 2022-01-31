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

public class avrz
  extends avry
{
  public avrz(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(avqj paramavqj)
  {
    return 1;
  }
  
  public View a(ViewGroup paramViewGroup, avqj paramavqj)
  {
    paramavqj = (avsa)paramavqj;
    paramViewGroup = LayoutInflater.from(this.a).inflate(2131561096, paramViewGroup, false);
    paramavqj.g = ((TextView)paramViewGroup.findViewById(2131379033));
    paramavqj.e = ((ImageView)paramViewGroup.findViewById(2131368753));
    paramavqj.f = ((ImageView)paramViewGroup.findViewById(2131368859));
    return paramViewGroup;
  }
  
  public avqj a()
  {
    return new avsa(this);
  }
  
  public String a(avqj paramavqj)
  {
    long l = ((avsj)((avsa)paramavqj).a).jdField_b_of_type_Long;
    if (l % 1000L > 500L) {}
    for (l = (int)l / 1000 + 1;; l = (int)l / 1000) {
      return String.valueOf(l);
    }
  }
  
  public void d(avqj paramavqj)
  {
    avsj localavsj = (avsj)paramavqj.a;
    if ((localavsj.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry != null) && (localavsj.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.publishState != 0))
    {
      avru.a(this.a, localavsj.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, 2);
      return;
    }
    super.d(paramavqj);
  }
  
  public void f(avqj paramavqj)
  {
    avsa localavsa = (avsa)paramavqj;
    avsj localavsj = (avsj)localavsa.a;
    paramavqj = bdnu.a(this.a, localavsa.a.a, localavsj.n);
    int j;
    String str;
    File localFile;
    boolean bool;
    if (TextUtils.isEmpty(paramavqj))
    {
      localavsa.g.setVisibility(8);
      j = xsm.a(this.a, 180.0F);
      str = (String)localavsa.e.getTag(2131377450);
      if (localavsj.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry == null) {
        break label544;
      }
      localFile = new File(localavsj.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath + "");
      bool = localFile.exists();
    }
    for (;;)
    {
      Object localObject;
      int i;
      if (bool)
      {
        localObject = localavsj.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath;
        paramavqj = (avqj)localObject;
        if (localavsj.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoWidth <= 0) {
          break label539;
        }
        paramavqj = (avqj)localObject;
        if (localavsj.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoHeight <= 0) {
          break label539;
        }
        i = localavsj.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoHeight * j / localavsj.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoWidth;
        paramavqj = (avqj)localObject;
      }
      for (;;)
      {
        label195:
        if (i * 3 > j * 4) {
          i = j * 4 / 3;
        }
        for (;;)
        {
          if (!TextUtils.equals(str, paramavqj))
          {
            localavsa.e.setTag(2131377450, paramavqj);
            localObject = (FrameLayout.LayoutParams)localavsa.e.getLayoutParams();
            if (localObject != null) {
              break label444;
            }
            localObject = new FrameLayout.LayoutParams(j, i);
            localavsa.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
          for (;;)
          {
            try
            {
              localObject = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.a.getResources().getDrawable(2130845085);
              ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.a.getResources().getDrawable(2130845085);
              if (!bool) {
                continue;
              }
              paramavqj = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject);
              paramavqj.setTag(bcyz.b(j, i, bdaq.a(this.a, 3.0F)));
              paramavqj.setDecodeHandler(bcyz.e);
              localavsa.e.setImageDrawable(paramavqj);
              return;
            }
            catch (Exception paramavqj)
            {
              label444:
              localavsa.e.setImageDrawable(this.a.getResources().getDrawable(2130845085));
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.i("ShortVideoMomentItemBuilder", 1, paramavqj.toString());
              return;
            }
            localavsa.g.setVisibility(0);
            if ((paramavqj instanceof SpannableString)) {
              localavsa.g.setMovementMethod(LinkMovementMethod.getInstance());
            }
            localavsa.g.setText(paramavqj);
            break;
            localObject = localavsj.jdField_a_of_type_JavaLangString;
            paramavqj = (avqj)localObject;
            if (localavsj.jdField_a_of_type_Int <= 0) {
              break label539;
            }
            paramavqj = (avqj)localObject;
            if (localavsj.jdField_b_of_type_Int <= 0) {
              break label539;
            }
            i = localavsj.jdField_b_of_type_Int * j / localavsj.jdField_a_of_type_Int;
            paramavqj = (avqj)localObject;
            break label195;
            if ((((FrameLayout.LayoutParams)localObject).width != j) || (((FrameLayout.LayoutParams)localObject).height != i))
            {
              ((FrameLayout.LayoutParams)localObject).width = j;
              ((FrameLayout.LayoutParams)localObject).height = i;
              localavsa.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
              continue;
              paramavqj = URLDrawable.getDrawable(paramavqj, (URLDrawable.URLDrawableOptions)localObject);
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
 * Qualified Name:     avrz
 * JD-Core Version:    0.7.0.1
 */