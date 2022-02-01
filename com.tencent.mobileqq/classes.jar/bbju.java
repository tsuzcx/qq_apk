import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.fragment.GroupSearchFragment;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class bbju
  extends Handler
{
  public bbju(GroupSearchFragment paramGroupSearchFragment, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    label1170:
    label3605:
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "log for search START_SEARCH keyword = " + this.a.jdField_c_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.a.jdField_c_of_type_JavaLangString))
      {
        this.a.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.a.b();
        this.a.a(this.a.jdField_c_of_type_JavaLangString);
        if (QLog.isColorLevel())
        {
          QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "GroupSearchFragment onViewCreated  startSearch");
          return;
          QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "log for search GET_LOCAL_MSG");
          this.a.jdField_a_of_type_Long = System.currentTimeMillis();
          this.a.jdField_a_of_type_Bbio.a(this.a.jdField_c_of_type_JavaUtilList);
          if ((this.a.jdField_c_of_type_JavaUtilList != null) && (!this.a.jdField_c_of_type_JavaUtilList.isEmpty()))
          {
            this.a.c();
            this.a.jdField_c_of_type_AndroidViewView.setVisibility(0);
            return;
            QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "log for search FINISH_LOCAL_MSG");
            if ((this.a.jdField_c_of_type_JavaUtilList != null) && (!this.a.jdField_c_of_type_JavaUtilList.isEmpty()))
            {
              this.a.c();
              this.a.jdField_c_of_type_AndroidViewView.setVisibility(8);
              this.a.f_(false);
            }
            this.a.c(false);
            this.a.jdField_a_of_type_Bbio.a(this.a.jdField_c_of_type_JavaUtilList);
            return;
            QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "log for search FINISH_NET_MSG");
            if ((this.a.jdField_c_of_type_JavaUtilList != null) && (!this.a.jdField_c_of_type_JavaUtilList.isEmpty()))
            {
              this.a.c();
              this.a.jdField_c_of_type_AndroidViewView.setVisibility(0);
              this.a.f_(false);
            }
            this.a.c(false);
            this.a.jdField_a_of_type_Bbio.a(this.a.jdField_c_of_type_JavaUtilList);
            if (this.a.jdField_c_of_type_JavaUtilList == null) {}
            int k;
            int j;
            for (int i = 0;; i = this.a.jdField_c_of_type_JavaUtilList.size())
            {
              k = i;
              if (i > 2) {
                break;
              }
              k = i;
              if (this.a.jdField_c_of_type_JavaUtilList == null) {
                break;
              }
              j = 0;
              for (;;)
              {
                k = i;
                if (j >= this.a.jdField_c_of_type_JavaUtilList.size()) {
                  break;
                }
                k = i;
                if ((this.a.jdField_c_of_type_JavaUtilList.get(j) instanceof bboh)) {
                  k = i - 1;
                }
                j += 1;
                i = k;
              }
            }
            if (k <= 0)
            {
              bbup.a("all_result", "noresult_local", new String[] { "" + this.a.jdField_c_of_type_JavaLangString });
              return;
              paramMessage = (List)paramMessage.obj;
              QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "handleMessage, log for search GET_LOCAL_CALLBACK_ON_UPDATE, onUpdate ");
              if ((paramMessage != null) && (paramMessage.size() != 0))
              {
                if (System.currentTimeMillis() - this.a.jdField_b_of_type_Long < 500L)
                {
                  this.a.jdField_b_of_type_Long = System.currentTimeMillis();
                  return;
                }
                this.a.jdField_b_of_type_Long = System.currentTimeMillis();
                if (this.a.jdField_c_of_type_JavaUtilList != null) {
                  this.a.jdField_c_of_type_JavaUtilList.clear();
                }
                long l;
                for (;;)
                {
                  this.a.jdField_c_of_type_JavaUtilList.addAll(paramMessage);
                  if ((this.a.jdField_b_of_type_Bboh != null) && (!this.a.jdField_c_of_type_JavaUtilList.contains(this.a.jdField_b_of_type_Bboh)))
                  {
                    this.a.jdField_c_of_type_JavaUtilList.add(this.a.jdField_b_of_type_Bboh);
                    this.a.jdField_b_of_type_Bboh.jdField_a_of_type_JavaLangString = this.a.jdField_c_of_type_JavaLangString;
                  }
                  l = System.currentTimeMillis();
                  if (l - this.a.jdField_a_of_type_Long < 50L) {
                    break;
                  }
                  this.a.jdField_b_of_type_AndroidOsHandler.removeMessages(10);
                  this.a.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(10);
                  return;
                  this.a.jdField_c_of_type_JavaUtilList = new ArrayList();
                }
                this.a.jdField_b_of_type_AndroidOsHandler.removeMessages(10);
                this.a.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(10, 50L - (l - this.a.jdField_a_of_type_Long));
                return;
                Object localObject1 = (List)paramMessage.obj;
                int m = paramMessage.arg1;
                boolean bool1;
                if ((m == 4) || (m == 5))
                {
                  bool1 = true;
                  label876:
                  QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "handleMessage log for search , GET_LOCAL_CALLBACK_ON_FINISH, onFinish  status = " + m + " isFinish" + bool1);
                  if (localObject1 != null) {
                    break label3601;
                  }
                }
                label1095:
                label1888:
                label2543:
                label3574:
                Object localObject2;
                for (paramMessage = new ArrayList();; paramMessage = localObject2)
                {
                  if ((paramMessage.size() == 0) && (!bool1)) {
                    break label3605;
                  }
                  if ((System.currentTimeMillis() - this.a.jdField_b_of_type_Long < 500L) && (!bool1))
                  {
                    this.a.jdField_b_of_type_Long = System.currentTimeMillis();
                    return;
                    bool1 = false;
                    break label876;
                  }
                  this.a.jdField_b_of_type_Long = System.currentTimeMillis();
                  this.a.jdField_c_of_type_JavaUtilList = paramMessage;
                  Object localObject3;
                  Object localObject4;
                  Object localObject5;
                  if (bool1)
                  {
                    if ((GroupSearchFragment.a(this.a) != 21) || (bbgu.a() != 0))
                    {
                      i = 0;
                      if (i >= this.a.jdField_c_of_type_JavaUtilList.size()) {
                        break label3586;
                      }
                      if ((this.a.jdField_c_of_type_JavaUtilList.get(i) instanceof bbmh))
                      {
                        localObject3 = (bbmh)this.a.jdField_c_of_type_JavaUtilList.get(i);
                        localObject1 = (bbmf)this.a.jdField_c_of_type_JavaUtilList.get(i - 1);
                        i = 0;
                      }
                    }
                    for (;;)
                    {
                      if (i < this.a.jdField_c_of_type_JavaUtilList.size())
                      {
                        if ((this.a.jdField_c_of_type_JavaUtilList.get(i) instanceof bbmm))
                        {
                          localObject4 = (bbmm)this.a.jdField_c_of_type_JavaUtilList.get(i);
                          localObject5 = (bbmf)this.a.jdField_c_of_type_JavaUtilList.get(i - 1);
                          this.a.jdField_c_of_type_JavaUtilList.remove(localObject1);
                          this.a.jdField_c_of_type_JavaUtilList.remove(localObject3);
                          this.a.jdField_c_of_type_JavaUtilList.remove(localObject4);
                          this.a.jdField_c_of_type_JavaUtilList.remove(localObject5);
                          k = 0;
                          j = 0;
                          i = -1;
                          while (j < paramMessage.size())
                          {
                            bbrf.a(paramMessage.get(j), this.a.jdField_c_of_type_JavaLangString, GroupSearchFragment.a(this.a));
                            if (!(paramMessage.get(j) instanceof bbmo)) {
                              break label3574;
                            }
                            i = j;
                            if ((paramMessage.get(j) instanceof bbmi)) {
                              k = j + 1;
                            }
                            if ((paramMessage.get(j) instanceof bbmk)) {
                              k = j + 1;
                            }
                            j += 1;
                          }
                          i += 1;
                          break;
                        }
                        i += 1;
                        continue;
                        this.a.jdField_a_of_type_Bboh.jdField_a_of_type_JavaLangString = this.a.jdField_c_of_type_JavaLangString;
                        if ((k == 0) && (i >= 0))
                        {
                          j = i + 1;
                          this.a.jdField_c_of_type_JavaUtilList.add(j, this.a.jdField_a_of_type_Bboh);
                          j += 1;
                        }
                        for (;;)
                        {
                          bbup.a("all_result", "exp_people_group", new String[] { this.a.jdField_c_of_type_JavaLangString });
                          bbrf.a(null, 0, GroupSearchFragment.a(this.a), "0X8009D3E", 0, 0, null, null);
                          if ((localObject3 == null) || (((bbmh)localObject3).a() == null) || (((bbmh)localObject3).a().size() <= 0)) {
                            break label1920;
                          }
                          localObject4 = new StringBuilder();
                          k = 1;
                          while (k < ((bbmh)localObject3).a().size() - 1)
                          {
                            ((bblw)((bbmh)localObject3).a().get(k)).h = (k - 1);
                            k += 1;
                          }
                          this.a.jdField_c_of_type_JavaUtilList.add(k, this.a.jdField_a_of_type_Bboh);
                          j = k + 1;
                        }
                        int n = Math.min(((bbmh)localObject3).a().size(), ((bbmh)localObject3).a());
                        if (n > 0)
                        {
                          k = 0;
                          while (k < n - 1)
                          {
                            localObject5 = (bblw)((bbmh)localObject3).a().get(k);
                            ((StringBuilder)localObject4).append(((bblw)localObject5).b + "::");
                            k += 1;
                          }
                          localObject5 = (bblw)((bbmh)localObject3).a().get(n - 1);
                          ((StringBuilder)localObject4).append(((bblw)localObject5).b + "");
                        }
                        if (((bblw)((bbmh)localObject3).a().get(0)).jdField_c_of_type_JavaLangString.equals(this.a.jdField_c_of_type_JavaLangString)) {
                          if (i < 0)
                          {
                            this.a.jdField_c_of_type_JavaUtilList.add(0, localObject1);
                            this.a.jdField_c_of_type_JavaUtilList.add(1, localObject3);
                            bbup.a("all_result", "exp_function", new String[] { "" + this.a.jdField_c_of_type_JavaLangString, "" + ((StringBuilder)localObject4).toString(), "", "1" });
                            localObject3 = ((bblw)((bbmh)localObject3).a().get(0)).b();
                            bbrf.a(null, 0, GroupSearchFragment.a(this.a), "0X8009D34", 0, 0, (String)localObject3, null);
                            if (this.a.jdField_c_of_type_JavaUtilList.size() >= 2) {}
                            if ((localObject1 != null) && (((bbmf)localObject1).a())) {
                              bbrf.a(null, 0, GroupSearchFragment.a(this.a), "0X8009D4A", 0, 0, null, null);
                            }
                            if (this.a.g != 6) {
                              break label2340;
                            }
                            this.a.h = 0;
                            if (this.a.g != 0) {
                              break label2322;
                            }
                            paramMessage = paramMessage.iterator();
                          }
                        }
                        for (;;)
                        {
                          label1957:
                          if (!paramMessage.hasNext()) {
                            break label2322;
                          }
                          localObject1 = paramMessage.next();
                          if (((localObject1 instanceof blkm)) || ((localObject1 instanceof atig)) || ((localObject1 instanceof bbmi)) || ((localObject1 instanceof bbmp)) || ((localObject1 instanceof bbmk)) || ((localObject1 instanceof bbml)) || ((localObject1 instanceof bbkq)) || (((localObject1 instanceof bblw)) && (((bblw)localObject1).d() == 268435456)))
                          {
                            if ((localObject1 instanceof bbmx))
                            {
                              localObject1 = (bbmx)localObject1;
                              if ((localObject1 == null) || (((bbmx)localObject1).a() == null)) {}
                              for (i = 0;; i = ((bbmx)localObject1).a().size())
                              {
                                localObject3 = this.a;
                                j = ((GroupSearchFragment)localObject3).h;
                                ((GroupSearchFragment)localObject3).h = (Math.min(i, ((bbmx)localObject1).a()) + j);
                                break label1957;
                                this.a.jdField_c_of_type_JavaUtilList.add(i + 1, localObject1);
                                this.a.jdField_c_of_type_JavaUtilList.add(i + 2, localObject3);
                                break;
                                this.a.jdField_c_of_type_JavaUtilList.add(j, localObject1);
                                this.a.jdField_c_of_type_JavaUtilList.add(j + 1, localObject3);
                                bbup.a("all_result", "exp_function", new String[] { "" + this.a.jdField_c_of_type_JavaLangString, "" + ((StringBuilder)localObject4).toString(), "", "0" });
                                bbrf.a(null, 0, GroupSearchFragment.a(this.a), "0X8009D48", 0, 0, null, null);
                                break label1888;
                              }
                            }
                            localObject1 = this.a;
                            ((GroupSearchFragment)localObject1).h += 1;
                          }
                        }
                        paramMessage = this.a;
                        if (m == 4)
                        {
                          i = 1;
                          label2335:
                          paramMessage.jdField_a_of_type_Int = i;
                          label2340:
                          boolean bool2 = false;
                          if ((this.a.getActivity() instanceof bbgw)) {
                            bool2 = ((bbgw)this.a.getActivity()).a();
                          }
                          if (QLog.isColorLevel()) {
                            QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "onFinish(). matchCount=" + this.a.h + " forceRequestStatus=" + this.a.g);
                          }
                          if (UniteSearchActivity.a(GroupSearchFragment.b(this.a), GroupSearchFragment.a(this.a))) {
                            break label2881;
                          }
                          if (this.a.g == 0) {
                            this.a.g = 4;
                          }
                          label2465:
                          if (bool2) {
                            break label2907;
                          }
                          paramMessage = this.a;
                          if (m != 5) {
                            break label2902;
                          }
                          i = 4;
                          label2483:
                          paramMessage.jdField_a_of_type_Int = i;
                          this.a.g();
                          i = 12;
                        }
                      }
                    }
                  }
                  for (;;)
                  {
                    label2498:
                    l = System.currentTimeMillis();
                    if (l - this.a.jdField_a_of_type_Long >= 50L)
                    {
                      this.a.jdField_b_of_type_AndroidOsHandler.removeMessages(i);
                      this.a.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(i);
                      if (!bool1) {
                        break label2951;
                      }
                      j = 0;
                      i = j;
                      if (this.a.jdField_c_of_type_JavaUtilList == null) {
                        break label3389;
                      }
                      i = j;
                      if (this.a.jdField_c_of_type_JavaUtilList.size() <= 0) {
                        break label3389;
                      }
                      paramMessage = this.a.jdField_c_of_type_JavaUtilList.iterator();
                      i = 0;
                      j = 0;
                      if (!paramMessage.hasNext()) {
                        break label3387;
                      }
                      localObject1 = paramMessage.next();
                      if ((!(localObject1 instanceof blkm)) && (!(localObject1 instanceof atig))) {
                        break label2953;
                      }
                      j += 1;
                      localObject3 = new bbhe();
                      k = i + 1;
                      ((bbhe)localObject3).jdField_a_of_type_Int = k;
                      ((bbhe)localObject3).jdField_a_of_type_Long = bbhd.a((bbmx)localObject1);
                      ((bbhe)localObject3).jdField_a_of_type_JavaLangString = ((bbmx)localObject1).b();
                      bbhd.b.put((bbmx)localObject1, localObject3);
                      i = j;
                      j = k;
                    }
                    for (;;)
                    {
                      k = j;
                      if ((localObject1 instanceof bboh))
                      {
                        k = j;
                        if (((bboh)localObject1).jdField_a_of_type_Int == -1)
                        {
                          localObject3 = new bbhe();
                          k = j + 1;
                          ((bbhe)localObject3).jdField_a_of_type_Int = k;
                          ((bbhe)localObject3).jdField_a_of_type_Long = bbhd.a((bboh)localObject1);
                          ((bbhe)localObject3).jdField_a_of_type_JavaLangString = ((bboh)localObject1).jdField_a_of_type_JavaLangString;
                          bbhd.b.put((bboh)localObject1, localObject3);
                        }
                      }
                      if ((!(localObject1 instanceof bbmx)) || (((bbmx)localObject1).a() == null)) {
                        break label3138;
                      }
                      localObject3 = ((bbmx)localObject1).a().iterator();
                      while (((Iterator)localObject3).hasNext())
                      {
                        localObject4 = (bbmy)((Iterator)localObject3).next();
                        if ((localObject4 instanceof bbmz)) {
                          ((bbmz)localObject4).b(GroupSearchFragment.b(this.a));
                        }
                      }
                      i = 2;
                      break label2335;
                      label2881:
                      if (this.a.g != 0) {
                        break label2465;
                      }
                      this.a.g = 4;
                      break label2465;
                      label2902:
                      i = 3;
                      break label2483;
                      label2907:
                      i = 11;
                      break label2498;
                      this.a.jdField_b_of_type_AndroidOsHandler.removeMessages(i);
                      this.a.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(i, 50L - (l - this.a.jdField_a_of_type_Long));
                      break label2543;
                      break;
                      if ((localObject1 instanceof bbmx))
                      {
                        localObject3 = (bbmx)localObject1;
                        localObject4 = ((bbmx)localObject3).a();
                        k = i;
                        m = j;
                        if (localObject4 != null)
                        {
                          m = Math.min(((List)localObject4).size(), ((bbmx)localObject3).a());
                          k = 0;
                          while (k < Math.min(((List)localObject4).size(), ((bbmx)localObject3).a()))
                          {
                            localObject5 = new bbhe();
                            i += 1;
                            ((bbhe)localObject5).jdField_a_of_type_Int = i;
                            ((bbhe)localObject5).jdField_a_of_type_Long = bbhd.a((bbmx)localObject1);
                            ((bbhe)localObject5).jdField_a_of_type_JavaLangString = ((bbmx)localObject1).b();
                            bbhd.b.put(((List)localObject4).get(k), localObject5);
                            k += 1;
                          }
                          m = j + m;
                          k = i;
                        }
                        i = m;
                        j = k;
                      }
                      else
                      {
                        k = j + 1;
                        j = i;
                        i = k;
                      }
                    }
                    label3138:
                    if ((localObject1 != null) && ((localObject1 instanceof bbmh)) && (((bbmh)localObject1).a() != null) && (((bbmh)localObject1).a().size() > 0))
                    {
                      j = 1;
                      label3180:
                      if (j != 0)
                      {
                        localObject3 = (bbmy)((bbmh)localObject1).a().get(0);
                        if ((((localObject3 instanceof bblw)) && (!TextUtils.isEmpty(((bblw)localObject3).jdField_c_of_type_JavaLangString))) && ((j == 0) || (!((bblw)localObject3).jdField_c_of_type_JavaLangString.equals(this.a.jdField_c_of_type_JavaLangString)))) {}
                      }
                      if ((localObject1 == null) || (!(localObject1 instanceof bbmm)) || (((bbmm)localObject1).a() == null) || (((bbmm)localObject1).a().size() <= 0)) {
                        break label3377;
                      }
                      j = 1;
                      label3292:
                      if (j != 0)
                      {
                        localObject1 = (bbmy)((bbmm)localObject1).a().get(0);
                        if ((!(localObject1 instanceof bbnd)) || (TextUtils.isEmpty(((bbnd)localObject1).c()))) {
                          break label3382;
                        }
                      }
                    }
                    label3377:
                    label3382:
                    for (j = 1;; j = 0)
                    {
                      if ((j != 0) && (((bbnd)localObject1).c().equals(this.a.jdField_c_of_type_JavaLangString))) {}
                      j = i;
                      i = k;
                      break;
                      j = 0;
                      break label3180;
                      j = 0;
                      break label3292;
                    }
                    label3387:
                    i = j;
                    label3389:
                    paramMessage = new JSONObject();
                    try
                    {
                      paramMessage.put("project", bbrf.a());
                      paramMessage.put("event_src", "client");
                      paramMessage.put("nav_num", i);
                      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
                      bbrf.a((QQAppInterface)localObject1, new ReportModelDC02528().module("all_result").action("exp_items").ver1(this.a.jdField_c_of_type_JavaLangString).ver2(bbrf.a(GroupSearchFragment.a(this.a))).ver7(paramMessage.toString()).session_id(((QQAppInterface)localObject1).getCurrentAccountUin() + bbhd.jdField_a_of_type_Long));
                      bbup.a("all_result", "exp_all_result", new String[] { this.a.jdField_c_of_type_JavaLangString });
                      return;
                    }
                    catch (JSONException localJSONException)
                    {
                      for (;;)
                      {
                        QLog.e("Q.uniteSearch.GroupSearchFragment", 2, "e = " + localJSONException);
                      }
                    }
                    break label1286;
                    localObject5 = null;
                    localObject4 = null;
                    break label1170;
                    localObject3 = null;
                    localObject2 = null;
                    break label1095;
                    i = 10;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbju
 * JD-Core Version:    0.7.0.1
 */