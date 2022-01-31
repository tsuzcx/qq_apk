import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.pb.addcontacts.AccountSearchPb.search;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.comm;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class awpz
  implements awqb<awof>
{
  abstract awof a(afgx paramafgx, List<awog> paramList, String paramString1, boolean paramBoolean, String paramString2);
  
  abstract awog a(AccountSearchPb.hotwordrecord paramhotwordrecord, String paramString1, CharSequence paramCharSequence1, String paramString2, CharSequence paramCharSequence2);
  
  abstract awog a(AccountSearchPb.record paramrecord, String paramString, CharSequence paramCharSequence);
  
  public List<awof> a(Object... paramVarArgs)
  {
    boolean bool2 = false;
    if ((paramVarArgs == null) || (paramVarArgs.length < 3)) {
      return null;
    }
    if ((paramVarArgs[0] instanceof SummaryCardBusiEntry.comm)) {}
    label145:
    label328:
    Object localObject2;
    for (Object localObject1 = (SummaryCardBusiEntry.comm)paramVarArgs[0];; localObject2 = null)
    {
      if ((paramVarArgs[1] instanceof byte[])) {}
      for (Object localObject3 = (byte[])paramVarArgs[1];; localObject3 = null)
      {
        if ((paramVarArgs[2] instanceof String)) {}
        for (paramVarArgs = (String)paramVarArgs[2];; paramVarArgs = null)
        {
          Object localObject4;
          afgx localafgx;
          for (;;)
          {
            if ((localObject1 == null) || (localObject3 == null)) {
              break label763;
            }
            localObject4 = new AccountSearchPb.search();
            localafgx = new afgx();
            try
            {
              ((AccountSearchPb.search)localObject4).mergeFrom((byte[])localObject3);
              localafgx.jdField_a_of_type_Int = ((SummaryCardBusiEntry.comm)localObject1).service.get();
              localafgx.jdField_b_of_type_Int = ((AccountSearchPb.search)localObject4).start.get();
              if (((AccountSearchPb.search)localObject4).end.get() != 1) {
                break label601;
              }
              bool1 = true;
              localafgx.jdField_a_of_type_Boolean = bool1;
              localafgx.jdField_b_of_type_JavaUtilList = ((AccountSearchPb.search)localObject4).list.get();
              localafgx.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord = ((AccountSearchPb.hotwordrecord)((AccountSearchPb.search)localObject4).hotword_record.get());
              localafgx.jdField_a_of_type_JavaUtilList = ((AccountSearchPb.search)localObject4).highlight.get();
              localafgx.jdField_a_of_type_JavaLangString = ((AccountSearchPb.search)localObject4).article_more_url.get();
              localafgx.jdField_b_of_type_Boolean = ((AccountSearchPb.search)localObject4).bool_keyword_suicide.get();
              if ((localafgx.jdField_b_of_type_JavaUtilList != null) && (localafgx.jdField_b_of_type_JavaUtilList.size() > 0))
              {
                if (localafgx.jdField_a_of_type_Int != 80000000) {
                  break label607;
                }
                localObject1 = ((AccountSearchPb.search)localObject4).list.get().iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject3 = (AccountSearchPb.record)((Iterator)localObject1).next();
                  if (((AccountSearchPb.record)localObject3).sign.get() != null) {
                    ((AccountSearchPb.record)localObject3).richStatus = RichStatus.parseStatus(((AccountSearchPb.record)localObject3).sign.get().toByteArray());
                  }
                }
              }
              if (localafgx.jdField_b_of_type_JavaUtilList == null) {
                break;
              }
            }
            catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
            {
              localInvalidProtocolBufferMicroException.printStackTrace();
            }
          }
          int i;
          label522:
          AccountSearchPb.record localrecord;
          if (localafgx.jdField_b_of_type_JavaUtilList.size() != 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("search", 2, "recordList size " + localafgx.jdField_b_of_type_JavaUtilList.size());
            }
            new ArrayList().add(localafgx);
            localObject3 = new ArrayList(3);
            int j = localafgx.jdField_b_of_type_JavaUtilList.size();
            localObject4 = localafgx.jdField_a_of_type_JavaLangString;
            localObject2 = (AccountSearchPb.hotwordrecord)localafgx.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.get();
            if ((localObject2 != null) && (((AccountSearchPb.hotwordrecord)localObject2).hotword.has())) {
              ((List)localObject3).add(a((AccountSearchPb.hotwordrecord)localObject2, paramVarArgs, awvy.a(((AccountSearchPb.hotwordrecord)localObject2).hotword.get(), (ArrayList)localafgx.jdField_a_of_type_JavaUtilList, 255), (String)localObject4, awvy.a(((AccountSearchPb.hotwordrecord)localObject2).hotword_title.get(), (ArrayList)localafgx.jdField_a_of_type_JavaUtilList, 255)));
            }
            i = 0;
            if (i >= j) {
              break label676;
            }
            localrecord = (AccountSearchPb.record)localafgx.jdField_b_of_type_JavaUtilList.get(i);
            if (localafgx.jdField_a_of_type_Int != 80000003) {
              break label655;
            }
          }
          label655:
          for (localObject2 = awvy.a(localrecord.name.get(), (ArrayList)localafgx.jdField_a_of_type_JavaUtilList, 255);; localObject2 = SearchBaseFragment.a(localrecord.name.get(), localafgx.jdField_a_of_type_JavaUtilList))
          {
            ((List)localObject3).add(a(localrecord, paramVarArgs, (CharSequence)localObject2));
            i += 1;
            break label522;
            label601:
            bool1 = false;
            break label145;
            label607:
            if ((localafgx.jdField_a_of_type_Int != 80000001) || (!((AccountSearchPb.search)localObject4).bool_location_group.has())) {
              break label328;
            }
            if (((AccountSearchPb.search)localObject4).bool_location_group.get()) {}
            for (i = 1;; i = 2)
            {
              localafgx.c = i;
              break label328;
              break;
            }
          }
          label676:
          boolean bool1 = bool2;
          if (localafgx.jdField_a_of_type_Int == 80000001) {
            if (localafgx.c != 2) {
              break label754;
            }
          }
          label754:
          for (bool1 = true;; bool1 = false)
          {
            localObject2 = new ArrayList(3);
            paramVarArgs = a(localafgx, (List)localObject3, paramVarArgs, bool1, (String)localObject4);
            ((List)localObject2).add(new awnn(paramVarArgs));
            ((List)localObject2).add(paramVarArgs);
            return localObject2;
          }
        }
        label763:
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awpz
 * JD-Core Version:    0.7.0.1
 */