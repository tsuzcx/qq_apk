package com.tencent.mobileqq.ar.keying;

public class SeriouslyChromaKey
  extends KeyingBase
{
  public SeriouslyChromaKey(int paramInt)
  {
    super(paramInt);
    this.j = "    float u_screenWeight = 1.0;\n    float u_balance = 1.0;\n    float u_clipBlack = 0.0;\n    float u_clipWhite = 1.0;\n    float screenFmin = min(min(u_screenColor.r, u_screenColor.g), u_screenColor.b);\n    float screenFmax = max(max(u_screenColor.r, u_screenColor.g), u_screenColor.b);\n    vec3 screenPrimary = step(screenFmax, u_screenColor.rgb);\n    float secondaryComponents = dot(1.0 - screenPrimary, u_screenColor.rgb);\n    float screenSat = screenFmax - mix(secondaryComponents - screenFmin, secondaryComponents / 2.0, u_balance);\n    float fmin = min(min(gl_FragColor.r, gl_FragColor.g), gl_FragColor.b);\n    float fmax = max(max(gl_FragColor.r, gl_FragColor.g), gl_FragColor.b);\n    vec3 pixelPrimary = step(fmax, gl_FragColor.rgb);\n    secondaryComponents = dot(1.0 - pixelPrimary, gl_FragColor.rgb);\n    float pixelSat = fmax - mix(secondaryComponents - fmin, secondaryComponents / 2.0, u_balance);\n    float diffPrimary = dot(abs(pixelPrimary - screenPrimary), vec3(1.0));\n    float solid = step(1.0, step(pixelSat, 0.1) + step(fmax, 0.1) + diffPrimary);\n    float alpha = max(0.0, 1.0 - pixelSat / screenSat);\n    alpha = smoothstep(u_clipBlack, u_clipWhite, alpha);\n    vec4 semiTransparentPixel = vec4((gl_FragColor.rgb - (1.0 - alpha) * u_screenColor.rgb * u_screenWeight), alpha);\n    vec4 pixel = mix(semiTransparentPixel, gl_FragColor, solid);\n    gl_FragColor = pixel;\n";
  }
  
  protected void a() {}
  
  protected void a(KeyingParams paramKeyingParams) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.keying.SeriouslyChromaKey
 * JD-Core Version:    0.7.0.1
 */