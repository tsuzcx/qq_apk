package com.squareup.okhttp;

public final class ConnectionSpec$Builder
{
  private String[] cipherSuites;
  private boolean supportsTlsExtensions;
  private boolean tls;
  private String[] tlsVersions;
  
  public ConnectionSpec$Builder(ConnectionSpec paramConnectionSpec)
  {
    this.tls = ConnectionSpec.access$400(paramConnectionSpec);
    this.cipherSuites = ConnectionSpec.access$500(paramConnectionSpec);
    this.tlsVersions = ConnectionSpec.access$600(paramConnectionSpec);
    this.supportsTlsExtensions = ConnectionSpec.access$700(paramConnectionSpec);
  }
  
  ConnectionSpec$Builder(boolean paramBoolean)
  {
    this.tls = paramBoolean;
  }
  
  public Builder allEnabledCipherSuites()
  {
    if (!this.tls) {
      throw new IllegalStateException("no cipher suites for cleartext connections");
    }
    this.cipherSuites = null;
    return this;
  }
  
  public Builder allEnabledTlsVersions()
  {
    if (!this.tls) {
      throw new IllegalStateException("no TLS versions for cleartext connections");
    }
    this.tlsVersions = null;
    return this;
  }
  
  public ConnectionSpec build()
  {
    return new ConnectionSpec(this, null);
  }
  
  public Builder cipherSuites(CipherSuite... paramVarArgs)
  {
    if (!this.tls) {
      throw new IllegalStateException("no cipher suites for cleartext connections");
    }
    String[] arrayOfString = new String[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      arrayOfString[i] = paramVarArgs[i].javaName;
      i += 1;
    }
    return cipherSuites(arrayOfString);
  }
  
  public Builder cipherSuites(String... paramVarArgs)
  {
    if (!this.tls) {
      throw new IllegalStateException("no cipher suites for cleartext connections");
    }
    if (paramVarArgs.length == 0) {
      throw new IllegalArgumentException("At least one cipher suite is required");
    }
    this.cipherSuites = ((String[])paramVarArgs.clone());
    return this;
  }
  
  public Builder supportsTlsExtensions(boolean paramBoolean)
  {
    if (!this.tls) {
      throw new IllegalStateException("no TLS extensions for cleartext connections");
    }
    this.supportsTlsExtensions = paramBoolean;
    return this;
  }
  
  public Builder tlsVersions(TlsVersion... paramVarArgs)
  {
    if (!this.tls) {
      throw new IllegalStateException("no TLS versions for cleartext connections");
    }
    String[] arrayOfString = new String[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      arrayOfString[i] = paramVarArgs[i].javaName;
      i += 1;
    }
    return tlsVersions(arrayOfString);
  }
  
  public Builder tlsVersions(String... paramVarArgs)
  {
    if (!this.tls) {
      throw new IllegalStateException("no TLS versions for cleartext connections");
    }
    if (paramVarArgs.length == 0) {
      throw new IllegalArgumentException("At least one TLS version is required");
    }
    this.tlsVersions = ((String[])paramVarArgs.clone());
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.ConnectionSpec.Builder
 * JD-Core Version:    0.7.0.1
 */